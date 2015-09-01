package brucephillips.java8examples;

import java.math.BigDecimal;
import java.util.Random;


/**
 * Defines a dummy implementation 
 * of getting a stock's price.
 * @author brucephillips
 */
public class StockPriceDummy {

    public static BigDecimal getStockPrice(final String stockSymbol) {
        
        Random randomGenerator = new Random();
        
        int base = randomGenerator.nextInt(99);
        
        return new BigDecimal(base);
        
    }
}
