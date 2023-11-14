import fr.einfolearning.tp2.metiers.TextBuffer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import javax.xml.soap.Text;

public class TextBufferTest {

    @Test
    public void TextBufferTest_toString() {

        // Arrange

        TextBuffer TB = new TextBuffer("Salut");
        String expectTB = "Salut";


        // Act
        String textTB = TB.toString();

        // Assert
        Assertions.assertEquals(TB, expectTB);

    }
}

