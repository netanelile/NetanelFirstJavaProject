package ConversionLogic;

import ConversionLogic.Coin;

public class ILS extends Coin {

    private final double value = 0.28;
    private final String text = "ILS to USD";

    /**
     * @return Actual ILS rate value
     */
    @Override
    public double getValue() {
        return value;
    }

    /**
     * @return Actual ILS text
     */
    @Override
    public String conversionText() {
        return text;
    }

    /**
     * @param input number from the user to calculate and convert to ILS
     * @return calculated value to ILS
     */
    @Override
    public double calculate(double input) {
        return getValue() * input;
    }
}
