/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brucephillips.java8examples;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * See: http://winterbe.com/posts/2014/03/16/java-8-tutorial/
 * @author brucephillips
 */
public class LambdaSortApp {
    
    
    public static void main(String [] args) {
        
        String[] namesAry = {"Tom", "Bruce", "Jeff"};
         
        List<String> names = Arrays.asList(namesAry);
        
        Collections.sort(names, (a, b) -> a.compareTo(b));

        names.forEach((name) -> System.out.print(name + " - "));
        
        
    }
    
}
