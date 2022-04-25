package ConversionLogic;

import ConversionLogic.Coin;

public class USD extends Coin {

    private final double value = 3.52;
    private final String text = "USD to ILS";

    /**
     * @return Actual USD rate value
     */
    @Override
    public double getValue() {return value;}

    /**
     * @return Actual USD text
     */
    @Override
    public String conversionText() {
        return text;
    }

    /**
     * @param input number from the user to calculate and convert to USD
     * @return calculated value to USD
     */
    @Override
    public double calculate(double input) {
        return getValue() * input;
    }
}
