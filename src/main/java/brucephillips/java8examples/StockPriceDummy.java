package brucephillips.java8examples;

import java.math.BigDecimal;
import java.util.Random;


public class StockPriceDummy {

    public static BigDecimal getStockPrice(final String ticker) {
        
        Random randomGenerator = new Random();
        
        int base = randomGenerator.nextInt(99);
        
        return new BigDecimal(base);
        
    }
}
