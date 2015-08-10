/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brucephillips.java8examples;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 *
 * @author brucephillips
 */
public class CollectionsApp {
    
    private final static List<String> friends = 
    Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
    
    public static void main(String [] args) {
        
        friends.forEach( name -> System.out.print(name + " "));
        
        System.out.println();

        friends.stream().map( name -> name.toUpperCase() ).forEach( name -> System.out.print(name + " ") );
        
        System.out.println();
        
        final List<String> startsWithN = friends.stream().filter(name -> name.startsWith("N")).collect(Collectors.toList());
        
        startsWithN.forEach( name -> System.out.print(name + " "));
        
        System.out.println();
        
    }
    
}
