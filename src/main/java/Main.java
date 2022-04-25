import ConversionLogic.Coin;
import ConversionLogic.CoinFactory;
import ConversionLogic.Coins;
import ConversionLogic.Results;
import UserInteractions.UserInteractions;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        UserInteractions ui = new UserInteractions();
        ArrayList<String> resultsList = new ArrayList<String>();
        Coin value = null;
        Results results;
        String fileName = "MyList";

        ui.welcome();
        do{
            switch (ui.chooseConversionRate()){
                case 1:
                    value = CoinFactory.getCoinInstance(Coins.USD);
                    break;
                case 2:
                    value = CoinFactory.getCoinInstance(Coins.ILS);
                    break;
                case 3:
                    value = CoinFactory.getCoinInstance(Coins.EUR);
                    break;
            }

            double result = value.calculate(ui.amountToConvert());
            String currency = value.conversionText();
            results = new Results(result, currency);
            resultsList.add(results.reportsDisplay());
            System.out.println(results.reportsDisplay());

        }while(ui.startOver());
        ui.endMessage();
        System.out.println(resultsList);
        ui.writeResultsToTextFile(resultsList, fileName);
        ui.openTextFile(fileName);

    }
}
