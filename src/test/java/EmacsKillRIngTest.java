import fr.einfolearning.tp2.metiers.EmacsKillRing;
import fr.einfolearning.tp2.metiers.TextBuffer;
import fr.einfolearning.tp2.metiers.exceptions.EmacsKillRingOverflowException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
}
