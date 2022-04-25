import ConversionLogic.Coin;
import ConversionLogic.USD;
import UserInteractions.UserInteractions;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;

/**
 * Unit Test Class for Currency Calculator program
 * @test valuesEntering Test that the user is able to enter values and they are calculate
 * @test conversionResultsTest Assert that the conversion is done correctly
 * @test assertResultsFile Assert the text file is generate correctly from the list and contains the same values
 */
public class TestCalculator {

    @Test
    public void valuesEntering(){
        Coin coin = new USD();
        UserInteractions ui = new UserInteractions();
        //Set value that will be set in the scanner in
        String userInput = String.format("5",
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

       //use the function that resive input from the user and calculate it, with the scanner in set to 5
        double result = coin.calculate(ui.amountToConvert());
        //get the result into an expected string variable
        String actual = Double.toString(result);
        //set the expected string variable
        String expected = "17.6";
        //Assert that the input that set inside the scanner was processed correctly
        assertEquals(expected, actual);
    }

    @Test
    public void conversionResultsTest(){
        Coin coin = new USD();
        String expected = Double.toString(coin.calculate(5));
        String actual = "17.6";
        assertEquals(expected, actual);
    }

    @Test
    public void assertResultsFile(){
        UserInteractions ui = new UserInteractions();
        ArrayList<String> list = new ArrayList<>();
        String fileName = "MyList";

        list.add("1.1");
        list.add("2.2");
        list.add("3.3");
        list.add("4.4");
        ui.writeResultsToTextFile(list, fileName);
        String expected = list.toString();
        String actual = ui.readResultsFromFileToList(fileName).toString();
        assertEquals(expected, actual);
    }
}
