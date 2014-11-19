/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brucephillips.java8examples;

import java.util.function.Function;

/**
 * See: http://winterbe.com/posts/2014/03/16/java-8-tutorial/
 * @author brucephillips
 */
public class FunctionApp {

    public static void main(String[] args) {

        Function<String, Integer> toInteger = Integer::valueOf;
        
        Function<String, String> backToString = toInteger.andThen(String::valueOf);

        String numberStr =  backToString.apply("123");     // "123"
        
        System.out.println( numberStr );

    }

}
