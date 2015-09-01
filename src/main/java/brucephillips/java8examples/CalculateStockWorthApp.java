package brucephillips.java8examples;

import java.math.BigDecimal;
import java.util.function.Function;

/**
 * Demonstrates delegating a function to another class's method.
 * Based on Chapter 4 of 
 * Functional Programming in Java 
 * (https://pragprog.com/book/vsjava8/functional-programming-in-java)
 * @author brucephillips
 */
public class CalculateStockWorthApp {

    private final Function<String, BigDecimal> findStockPrice;

    public BigDecimal computeStockWorth(final String stockSymbol, final int shares) {
        
        return findStockPrice.apply(stockSymbol).multiply(BigDecimal.valueOf(shares));
        
    }

    /**
     * Overloaded constructor that takes a Function - the Function expects to
     * be provided a String and will return a BigDecimal value.  This Function
     * will be used to determine the price of one Stock (identified by the 
     * String)
     * @param stockPriceFinder 
     */
    public CalculateStockWorthApp(final Function<String, BigDecimal> stockPriceFinder) {
        
        findStockPrice = stockPriceFinder;
        
    }

    public static void main(String[] args) {
        
        /*
        Create a CalculateStockWorthApp object by passing to the constructor the 
        getStockPrice method of class StockPriceDummy.
        */
        final CalculateStockWorthApp stockWorth = new CalculateStockWorthApp(StockPriceDummy::getStockPrice);
        

        System.out.println(String.format("10 shares of IBM worth: $%.2f",
                stockWorth.computeStockWorth("IBM", 10)));
        
    }
}
