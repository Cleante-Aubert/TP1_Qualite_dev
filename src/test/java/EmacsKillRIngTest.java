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
}
