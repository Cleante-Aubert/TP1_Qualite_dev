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
        textBuffer = new TextBuffer("Ceci est un test de la methode toString");
    }

    @Test
    public void should_return_string_when_create_textBuffer(){
        String expectTB = "Ceci est un test de la methode toString";


        // Act
        String textTB = textBuffer.toString();

        // Assert
        Assertions.assertEquals(textTB, expectTB);

    }

    @Test
    public void should_return_correct_max_when_create_textBuffer_with_string(){
        //ARrange
        int expectedMax = "Ceci est un test de la methode toString".length();

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
        int from = "Ceci est un test de la methode toString".length() -6;
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
        String expectedString="Ceci est un  de la methode toString";

        //Act
        textBuffer.del(from,to);

        //Assert
        assertThat(textBuffer.toString(),is(expectedString));

    }

    @Test
    public void should_delete_trunced_substring_where_to_out_of_limit(){
        //Arrange
        int from = "Ceci est un test de la methode toString".length() -6;
        int to = 200;
        String expectedString = "Ceci est un test de la methode to";

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
        String expectedString  = "Ceci est un test de la methode toString";

        // Act
        textBuffer.del(from,to);

        //Assert
        assertThat(textBuffer.toString(),is(expectedString));
    }

    // Test pour voir si la méthode del supprime bien tout
    @Test
    public void _should_del_all(){
        //Arrange
        int from = 0;
        int to = 100;
        String expectedTB = "";

        // Act
        textBuffer.del(from,to);

        // Assert
        assertThat(textBuffer.toString(),is(expectedTB));
    }


    // Test d'insertion dans un texte buffer d'un string entier
    @Test
    public void should_ins_string(){
        //Arrange
        String expectedString = "etes";
        int from = 1;
        int to = 5;

        //Act
        textBuffer.ins("test",2);

        //Assert
        String stringInserted = textBuffer.substr(from,to);
        assertThat(stringInserted,is(expectedString));
    }

    // Test de suppression en valeur négatives
    @Test
    public void should_supp_nothing(){
        // Arrange
        int from = -2;
        int to = -1;
        String expectedString="Ceci est un test de la methode toString";

        //Act
        textBuffer.del(from,to);

        //Assert
        assertThat(textBuffer.toString(),is(expectedString));

    }

    // Test de la méthode "substr" sur des valeures négatives

    @Test
    public void should_return_nothing(){
        // Arrange
        String expectedString = "";
        int from = -2;
        int to = -1;

        // Act
        String stringTB = textBuffer.substr(from,to);

        // Assert
        assertThat(stringTB,is(expectedString));

    }



    }
