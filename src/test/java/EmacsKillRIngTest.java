import fr.einfolearning.tp2.metiers.EmacsKillRing;
import fr.einfolearning.tp2.metiers.TextBuffer;
import fr.einfolearning.tp2.metiers.exceptions.EmacsKillRingOverflowException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;

public class EmacsKillRIngTest {
    private TextBuffer textBuffer;

    @Test
    public void should_throw_emacskill_ringoverflowexception_when_buffer_full(){
        //Arrange
        EmacsKillRing emacsKillRing = new EmacsKillRing();

        //Act
        try{
            for (int i = 0; i<emacsKillRing.MAX ; i++){
                emacsKillRing.add("test");
            }

        }
        catch(EmacsKillRingOverflowException e){
            Assertions.fail();
        }

        // Assert
        Assertions.assertThrows(EmacsKillRingOverflowException.class, ()->{ emacsKillRing.add("test");});

    }

    // Test de la méthode toString voir si elle retourne la bonne valeure
    @Test
    public void should_return_correct_string(){
        // Arrange
        EmacsKillRing emacsKillRing = new EmacsKillRing();
        String expectedString = "";

        // Act
        String res = emacsKillRing.toString();

        // Assert
        assertThat(res,is(expectedString));

    }

    @Test
    void testRotateFwd() {
        EmacsKillRing killRing = new EmacsKillRing();
        killRing.add("Text1");
        killRing.add("Text2");
        assertEquals("Text1", killRing.currentElt());
        killRing.rotateFwd();
        assertEquals("Text2", killRing.currentElt());
        killRing.rotateFwd();
        assertEquals("Text1", killRing.currentElt());
    }

    @Test
    void testIsEmpty() {
        EmacsKillRing killRing = new EmacsKillRing();
        assertTrue(killRing.isEmpty());
        killRing.add("Text");
        assertFalse(killRing.isEmpty());
    }

    @Test
    void testCurrentElt() {
        EmacsKillRing killRing = new EmacsKillRing();
        killRing.add("Text1");
        assertEquals("Text1", killRing.currentElt());
    }

    @Test
    void testToString() {
        EmacsKillRing killRing = new EmacsKillRing();
        killRing.add("Text1");
        killRing.add("Text2");
        assertEquals("[Text2, Text1]", killRing.toString());
    }
}
