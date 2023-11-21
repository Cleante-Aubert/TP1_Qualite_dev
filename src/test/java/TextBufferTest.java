import fr.einfolearning.tp2.metiers.TextBuffer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

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
        int from = "test de la méthode toString".length() -6;
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
        String expectedString = "Test de la méthode toString encore";

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
        String expectedString  = "Test de la méthode toString encore";

        // Act
        textBuffer.del(from,to);

        //Assert
        assertThat(textBuffer.toString(),is(expectedString));
    }

    // Test pour voir si la méthode maxP retourne bien la length
    @Test
    public void _should_return_length(){
        //Arrange
        TextBuffer TB = new TextBuffer("Salut");
        int expectTBLength = 5;

        // Act
        int bufferRes = TB.maxP();

        // Assert
        assertThat(TB,is(bufferRes));
    }

    // Test de la méthode "ins" afin de tester l'insertion à la bonne position et retourne le résultat attendu
    @Test
    public void should_ins_correct_position(){
        // Arrange
        TextBuffer TB = new TextBuffer("Salut");
        String expectedTBins = "Salutt";

        // Act
        TB.ins("t",6);

        // Assert
        assertThat(TB,is(expectedTBins));
    }

    // Test de la méthode "del", cela doit bien supprimer le text en entier
    @Test
    public void should_delete_correct_part(){
        // Arrange
        TextBuffer TB = new TextBuffer("ceci est un text d'exemple");
        int from = 1;
        int to = 27;

        // Act
        TB.del(from,to);

        // Assert
        assertThat(TB,is(""));
    }



    }
