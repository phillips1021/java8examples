package brucephillips.java8examples;

import brucephillips.java8examples.Metal.MetalType;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;


public class MetalApp {

    public static int totalMetalValues(final List<Metal> metals,
            final Predicate<Metal> metalSelector) {
        
        return metals.stream()
                .filter(metalSelector)
                .mapToInt(Metal::getValue)
                .sum();
        
    }

    public static void main(final String[] args) {
        
        List<Metal> metals = Arrays.asList(new Metal(Metal.MetalType.GOLD, 500),
                new Metal(Metal.MetalType.GOLD, 1500),
                new Metal(Metal.MetalType.SILVER, 300),
                new Metal(Metal.MetalType.SILVER, 900)
        );

        System.out.println("Total of all metals: "
                + totalMetalValues(metals, metal -> true));

        System.out.println("Total of silver metals: "
                + totalMetalValues(metals, metal -> metal.getType() == MetalType.SILVER));

        System.out.println("Total of stocks: "
                + totalMetalValues(metals, metal -> metal.getType() == MetalType.GOLD));
        
    }
}
