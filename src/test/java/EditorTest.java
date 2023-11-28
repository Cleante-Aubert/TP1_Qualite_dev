import fr.einfolearning.tp2.metiers.EmacsKillRing;
import fr.einfolearning.tp2.metiers.TextBuffer;
import fr.einfolearning.tp2.metiers.TextEditor;
import fr.einfolearning.tp2.metiers.exceptions.EmacsKillRingOverflowException;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import sun.security.krb5.internal.crypto.DesMacCksumType;

import javax.xml.soap.Text;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class EditorTest {

/*
    @BeforeEach
    public void init(){
        TextBuffer tb = mock(TextBuffer.class);
        EmacsKillRing emacsKillRing = mock(EmacsKillRing.class);
        TextEditor textEditor = new TextEditor("Bonjour à tous");
    }
*/
    @Test
    public void test_Yank() throws IllegalAccessException, EmacsKillRingOverflowException {

        try {
            TextBuffer tb = mock(TextBuffer.class);
            EmacsKillRing emacsKillRing = mock(EmacsKillRing.class);
            TextEditor textEditor = new TextEditor("Bonjour à tous");

            when(emacsKillRing.isEmpty()).thenReturn(false);
            when(emacsKillRing.currentElt()).thenReturn("Voici un test");
            when(tb.maxP()).thenReturn(100);
            textEditor.yank();
            textEditor.yankPop();
            verify(emacsKillRing, times(2)).currentElt();
            verify(tb).del(anyInt(), anyInt());
            verify(tb, times(2)).ins(eq("Voici un test"), anyInt());
        }
        catch (IllegalAccessException e){
            System.out.println(e.toString());
        }
    }

    @Test
    public void test_setters_getters(){
        TextEditor te = new TextEditor("voici un nouveau test");
        verify(te.setCursor(1),"V");
        te.setMark(2);



    }






}
