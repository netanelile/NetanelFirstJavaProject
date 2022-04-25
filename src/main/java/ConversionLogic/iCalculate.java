package ConversionLogic;

public interface iCalculate {

    /**
     * @param num Number to convert to certain curancy
     * @return test that explain from which to which currency.
     */
    double calculate(double num);
    String conversionText();
}
