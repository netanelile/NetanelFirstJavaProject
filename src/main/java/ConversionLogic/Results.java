package ConversionLogic;

public class Results {
    private double result;
   private String currency;

    /**
     * Constructor that set the parameters for the class
     * @param result the result of the calculated currancy
     * @param currency which currency is used
     */
    public Results(double result, String currency){
       setResult(result);
       setCurrency(currency);
    }

    public double getResult() {
        return result;
    }

    private void setResult(double result) {
        this.result = result;
    }

    private String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * @return a generated string that contains the calculated currency
     * and the text that explain from what to what we convert the currency.
     */
    public String reportsDisplay(){
        String results = Double.toString(getResult());
        return results + ',' + getCurrency();
    }
}
