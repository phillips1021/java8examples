/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brucephillips.java8examples;

import java.util.function.Predicate;

/**
 * See: http://winterbe.com/posts/2014/03/16/java-8-tutorial/
 * @author brucephillips
 */
public class PredicateApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Predicate<String> predicate = (s) -> s.length() > 0;

        System.out.println(predicate.test("foo") );  // true
        
        System.out.println(predicate.negate().test("foo"));     // false
        
        Predicate<String> isEmpty = String::isEmpty;
        
        String name = "";
        
        System.out.println(isEmpty.test(name)) ; //true

    }

}
