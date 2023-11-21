import fr.einfolearning.tp2.metiers.TextBuffer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;


public class TextBufferTest {

    private TextBuffer textBuffer;

    @BeforeEach
    public void init(){
        textBuffer = new TextBuffer("Test méthode toString");
    }

    @Test
    public void should_return_string_when_create_textBuffer(){
        TextBuffer TB = new TextBuffer("Salut");
        String expectTB = "Salut";


        // Act
        String textTB = TB.toString();

        // Assert
        Assertions.assertEquals(TB, expectTB);

    }

    @Test
    public void should_return_correct_max_when_create_textBuffer_with_string(){
        //ARrange
        int expectedMax = "voici une chaine de caractères test méthode toString ".length();

        //ACt
        int max = textBuffer.maxP();

        //Assert
        assertThat(max,is(expectedMax));
    }

    @Test
    public void should_return_same_insterted_string_when_insert_string() {
        //Arrange
        String expectedString = "test";
        int from = 4;
        int to = from+"test".length();

        //Act
        textBuffer.ins("test",4);

        //Assert
        String stringInserted = textBuffer.substr(from,to);
        assertThat(stringInserted,is(expectedString));
    }


    @Test
    public void should_return_correct_string_when_correct_to_from_parameter(){
        //Arrange
        int from = 12;
        int to = 16;
        String expectedString = "test";

        //Act
        String subStringRes = textBuffer.substr(from,to);

        //Assert
        assertThat(subStringRes,is(expectedString));

    }

    @Test
    public void should_return_trunced_string_when_to_out_of_limit(){

        //Arrange
        int from = "VOila un test de la méthode toString".length() -6;
        int to = 200;
        String expectedString = "String";

        // Act
        String subStringRes = textBuffer.substr(from,to);

        //Assert
        assertThat(subStringRes,is(expectedString));
    }

    @Test
    public void should_return_nothing_when_from_and_to_out_of_limit(){
        // Arrange
        int from = 200;
        int to = 200;
        String expectedString ="String";

        // ACt
        String subStringRes = textBuffer.substr(from,to);

        //Assert
        assertThat(subStringRes,is(""));
    }

    @Test
    public void should_delete_substring__where_when_from_and_incorrect(){
        //Arrange
        int from = 12;
        int to = 16;
        String expectedString="Test méthode toString";

        //Act
        textBuffer.del(from,to);

        //Assert
        assertThat(textBuffer.toString(),is(expectedString));

    }

    @Test
    public void should_delete_trunced_substring_where_to_out_of_limit(){
        //Arrange
        int from = "Test de la méthode toString encore".length() -6;
        int to = 200;
        String expectedString = "Ceci est un test de la méthode to";

        //Act
        textBuffer.del(from,to);

        //Assert
        assertThat(textBuffer.toString(),is(expectedString));
    }

    @Test
    public void _should_del_nothing(){
        //Arrange
        int from = 200;
        int to = 200;
        String expectedString  = "Et encore un test de la méthode toString";

        // Act
        textBuffer.del(from,to);

        //Assert
        assertThat(textBuffer.toString(),is(expectedString));



    }


    }
