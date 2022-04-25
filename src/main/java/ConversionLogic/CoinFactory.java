package ConversionLogic;

public class CoinFactory {

    /**
     * Used to get source of conversion rate if it would be ILS, USD or EUR
     * @param Coin from Enum Class
     * @return Currency Instance
     */
    public static Coin getCoinInstance(Coins Coin){
        switch (Coin) {
            case ILS:
                return new ILS();
            case USD:
                return new USD();
            case EUR:
                return new EUR();
        }
        return null;
    }
}
