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

    @Test
    public void test_Yank() throws IllegalAccessException, EmacsKillRingOverflowException {

            TextBuffer tb = mock(TextBuffer.class);
            EmacsKillRing mockEmacsKillRing = mock(EmacsKillRing.class);
            TextEditor textEditor = new TextEditor("Bonjour à tous");

            when(mockEmacsKillRing.currentElt()).thenReturn("Voici un test");
            when(tb.maxP()).thenReturn(100);
            textEditor.emacsKillring = mockEmacsKillRing;

            textEditor.yank();

            verify(mockEmacsKillRing, times(1)).currentElt();
            verify(tb, times(0)).ins(eq("Voici un test"), anyInt());
        }

    @Test
    public void testYankPop() throws IllegalAccessException, EmacsKillRingOverflowException {
        //try {
            // Création du mock pour EmacsKillRing
            EmacsKillRing mockEmacsKillRing = mock(EmacsKillRing.class);

            // TextEditor avec le mock
            TextEditor textEditor = new TextEditor("Test text");


            textEditor.setMark(0);
            textEditor.setCursor(5);
            textEditor.emacsKillring = mockEmacsKillRing;

            textEditor.yank(); // contexte pour yankPop

            when(mockEmacsKillRing.currentElt()).thenReturn("Test Text");

            // Injection du mock dans la classe à tester
            // Problème private changé en public.
            textEditor.emacsKillring = mockEmacsKillRing;

            // Appel de la méthode à tester
            textEditor.yankPop();

            // Vérification que rotateFwd() a bien été appelé sur le mock
            verify(mockEmacsKillRing, times(1)).rotateFwd();
        }
        /*
        catch (IllegalAccessException e) {
            System.out.println(e.toString());
        }
    }
    */

    @Test
    public void testYankPopAfterYank() throws IllegalAccessException, EmacsKillRingOverflowException {
        // Mock pour EmacsKillRing
        EmacsKillRing mockEmacsKillRing = mock(EmacsKillRing.class);

        // Création de l'instance de TextEditor avec le mock
        TextEditor textEditor = new TextEditor("Teste text 123");
        textEditor.setMark(0); // Marquage d'une position quelconque
        textEditor.setCursor(5); // Position du curseur quelconque

        when(mockEmacsKillRing.currentElt()).thenReturn("Mock Text 123");

        // Injection du mock dans la classe à tester
        textEditor.emacsKillring = mockEmacsKillRing;

        // Appel de la méthode yank
        textEditor.yank();

        // Appel de la méthode yankPop
        textEditor.yankPop();

        // Vérification que rotateFwd() a été appelé sur le mock
        verify(mockEmacsKillRing, times(1)).rotateFwd();

    }


    /*
   // Idée de test question KillRegion

    @Test
    public void testKillSection() throws IllegalAccessException, EmacsKillRingOverflowException {
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
        textEditor.killSection();

        // Création d'un ordre d'appel pour vérifier la séquence des appels
        InOrder inOrder = inOrder(mockTextBuffer, mockEmacsKillRing);

        // Vérification que getText est appelé en premier
        inOrder.verify(mockTextBuffer).substr(0, 5);

        // Vérification que add est appelé ensuite avec le message récupéré du TextBuffer
        inOrder.verify(mockEmacsKillRing).add("Mocked Text");
    }
    */


}
