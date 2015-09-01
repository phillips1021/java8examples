package brucephillips.java8examples;

import java.math.BigDecimal;
import java.util.function.Function;

public class CalculateStockWorth {

    private final Function<String, BigDecimal> findStockPrice;

    public BigDecimal computeStockWorth(final String ticker, final int shares) {
        
        return findStockPrice.apply(ticker).multiply(BigDecimal.valueOf(shares));
        
    }

    public CalculateStockWorth(final Function<String, BigDecimal> aPriceFinder) {
        
        findStockPrice = aPriceFinder;
        
    }

    public static void main(String[] args) {
        
        final CalculateStockWorth stockWorth = new CalculateStockWorth(StockPriceDummy::getStockPrice);
        

        System.out.println(String.format("10 shares of IBM worth: $%.2f",
                stockWorth.computeStockWorth("IBM", 10)));
        
    }
}
