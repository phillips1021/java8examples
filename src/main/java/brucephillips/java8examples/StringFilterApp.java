package brucephillips.java8examples;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Demonstrates decorating a Class with additional capabilities by using
 * lambda expressions. Based on
 * Chapter 4 of Functional Programming in Java
 * (https://pragprog.com/book/vsjava8/functional-programming-in-java)
 *
 * @author brucephillips
 */
public class StringFilterApp {

    /**
     * Expects to get a String and return a String
     */
    private Function<String, String> stringModifier;

    public String applyStringModifiers(final String inputString) {

        final String processedString = stringModifier.apply(inputString);

        return processedString;

    }

    public final void setStringModifier(final Function<String, String>... stringModifiers) {

        /*
        Compose each stringModifier into a chain so that each will be applied
        If there are no modifiers then just return the string
        */
        stringModifier = Stream.of(stringModifiers).reduce((aStringModifier, next) -> aStringModifier.compose(next)).orElse(string -> string);

    }

    public StringFilterApp() {

        setStringModifier();

    }

    public static void main(final String[] args) {

        final StringFilterApp stringFilterApp = new StringFilterApp();

        final Consumer<String> printCaptured = (modifierInfo)
                -> System.out.println(String.format("with %s: %s", modifierInfo,
                                stringFilterApp.applyStringModifiers("  bruce phillips  ")));

        System.out.println("//" + "START NO MODIFIER OUTPUT");
        printCaptured.accept("No String Modifier");
        System.out.println("//" + "END NO MODIFIER OUTPUT");
        
        
        System.out.println("//" + "START UPPER CASE STRING MODIFIER OUTPUT");
        stringFilterApp.setStringModifier(String::toUpperCase);
        printCaptured.accept("Upper Case String Modifier");
        System.out.println("//" + "END UPPER CASE STRING MODIFIER OUTPUT");
        
        
        System.out.println("//" + "START UPPER CASE STRING MODIFIER AND TRIM STRING MODIFIER OUTPUT");
        stringFilterApp.setStringModifier(String::toUpperCase, String::trim);
        printCaptured.accept("Upper Case and Trim String Modifiers");
        System.out.println("//" + "END UPPER CASE STRING MODIFIER AND TRIM STRING MODIFIER OUTPUT");

    }

}
