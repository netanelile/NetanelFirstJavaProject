package ConversionLogic;

public abstract class Coin implements iCalculate{

    /**
     * Abstract class to get the requested currency value
     * @return currency Value
     */
    public abstract double getValue();

    /**
     * @return conversionText The actual text that indicate from what to what we are converting.
     */
    public abstract String conversionText();

}
