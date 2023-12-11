import fr.einfolearning.tp2.metiers.EmacsKillRing;
import fr.einfolearning.tp2.metiers.TextBuffer;
import fr.einfolearning.tp2.metiers.TextEditor;
import fr.einfolearning.tp2.metiers.exceptions.EmacsKillRingOverflowException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

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
            verify(emacsKillRing, times(2)).currentElt();
            verify(tb).del(anyInt(), anyInt());
            verify(tb, times(2)).ins(eq("Voici un test"), anyInt());
        }
        catch (IllegalAccessException e){
            System.out.println(e.toString());
        }
    }
/*
    @Test
    public void test_setters_getters(){
        TextEditor te = new TextEditor("voici un nouveau test");
        verify(te.setCursor(1),"V");
        te.setMark(2);
    }
*/

    @Test
    void testYankPop() throws IllegalAccessException, EmacsKillRingOverflowException {
        // Création du mock pour EmacsKillRing
        EmacsKillRing mockEmacsKillRing = mock(EmacsKillRing.class);

        // Création de l'instance de TextEditor avec le mock
        TextEditor textEditor = new TextEditor("Sample text");
        textEditor.setMark(0); // Marquage d'une position quelconque
        textEditor.setCursor(5); // Position du curseur quelconque
        textEditor.yank(); // Préparation du contexte pour yankPop

        // Définition du comportement simulé pour currentElt() de l'EmacsKillRing mocké
        when(mockEmacsKillRing.currentElt()).thenReturn("Mocked Text");

        // Injection du mock dans la classe à tester
        // Problème private
        textEditor.emacsKillring = mockEmacsKillRing;

        // Appel de la méthode à tester
        textEditor.yankPop();

        // Vérification que rotateFwd() a bien été appelé sur le mock
        verify(mockEmacsKillRing, times(1)).rotateFwd();

        // assertEquals("Expected Result", textEditor.getBuffer());
    }

    @Test
    void testYankPopAfterYank() throws IllegalAccessException, EmacsKillRingOverflowException {
        // Création du mock pour EmacsKillRing
        EmacsKillRing mockEmacsKillRing = mock(EmacsKillRing.class);

        // Création de l'instance de TextEditor avec le mock
        TextEditor textEditor = new TextEditor("Sample text");
        textEditor.setMark(0); // Marquage d'une position quelconque
        textEditor.setCursor(5); // Position du curseur quelconque

        // Définition du comportement simulé pour currentElt() de l'EmacsKillRing mocké
        when(mockEmacsKillRing.currentElt()).thenReturn("Mocked Text");

        // Injection du mock dans la classe à tester
        textEditor.emacsKillring = mockEmacsKillRing;

        // Appel de la méthode yank
        textEditor.yank();

        // Appel de la méthode yankPop
        textEditor.yankPop();

        // Vérification que rotateFwd() a bien été appelé sur le mock
        verify(mockEmacsKillRing, times(1)).rotateFwd();

        // Vérification que le texte du buffer est conforme aux attentes après l'exécution de yankPop
        // assertEquals("Expected Result", textEditor.getBuffer());
    }
    }

    /*
    Idée de test question KillRegion

    @Test
    void testKillRegion() throws IllegalAccessException, EmacsKillRingOverflowException {
        // Création des mocks pour TextBuffer et EmacsKillRing
        TextBuffer mockTextBuffer = mock(TextBuffer.class);
        EmacsKillRing mockEmacsKillRing = mock(EmacsKillRing.class);

        // Création de l'instance de TextEditor avec les mocks
        TextEditor textEditor = new TextEditor(mockTextBuffer, mockEmacsKillRing);
        textEditor.setMark(0); // Marquage d'une position quelconque
        textEditor.setCursor(5); // Position du curseur quelconque

        // Définition du comportement simulé pour getText et add de TextBuffer et EmacsKillRing
        when(mockTextBuffer.substr(0, 5)).thenReturn("Mocked Text");
        doNothing().when(mockEmacsKillRing).add(anyString());

        // Appel de la méthode à tester
        textEditor.killRegion();

        // Création d'un ordre d'appel pour vérifier la séquence des appels
        InOrder inOrder = inOrder(mockTextBuffer, mockEmacsKillRing);

        // Vérification que getText est appelé en premier
        inOrder.verify(mockTextBuffer).substr(0, 5);

        // Vérification que add est appelé ensuite avec le message récupéré du TextBuffer
        inOrder.verify(mockEmacsKillRing).add("Mocked Text");
    }
    */


}
