package ConversionLogic;

public class EUR extends Coin {

    private final double value = 4.23;
    private final String text = "ILS to ERO";
    /**
     * @return Actual ERO rate value
     */
    @Override
    public double getValue() {return value;}

    /**
     * @return Actual ERO text
     */
    @Override
    public String conversionText() {
        return text;
    }

    /**
     * @param input number from the user to calculate and convert to ERO
     * @return calculated value to ERO
     */
    @Override
    public double calculate(double input) {
        return getValue() * input;
    }
}
