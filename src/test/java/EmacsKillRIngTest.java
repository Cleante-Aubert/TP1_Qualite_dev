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

    /*
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
    void testRotateFwd() throws EmacsKillRingOverflowException {
        EmacsKillRing killRing = new EmacsKillRing();
        killRing.add("Text1");
        killRing.add("Text2");
        Assertions.assertEquals("Text1", killRing.currentElt());
        killRing.rotateFwd();
        Assertions.assertEquals("Text2", killRing.currentElt());
        killRing.rotateFwd();
        Assertions.assertEquals("Text1", killRing.currentElt());
    }

    @Test
    void testIsEmpty() throws EmacsKillRingOverflowException {
        EmacsKillRing killRing = new EmacsKillRing();
        Assertions.assertTrue(killRing.isEmpty());
        killRing.add("Text");
        Assertions.assertFalse(killRing.isEmpty());
    }

    @Test
    void testCurrentElt() throws EmacsKillRingOverflowException {
        EmacsKillRing killRing = new EmacsKillRing();
        killRing.add("Text1");
        Assertions.assertEquals("Text1", killRing.currentElt());
    }

    @Test
    void testToString() throws EmacsKillRingOverflowException {
        EmacsKillRing killRing = new EmacsKillRing();
        killRing.add("Text1");
        killRing.add("Text2");
        Assertions.assertEquals("[Text2, Text1]", killRing.toString());
    }

     */
}