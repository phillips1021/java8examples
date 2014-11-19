/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brucephillips.java8examples;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author brucephillips
 */
public class Java8LambdaExamplesApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Java 8 Lambda forEach
        String[] atp = {"Rafael Nadal", "Novak Djokovic", "Stanislas Wawrinka", "David Ferrer", "Roger Federer", "Andy Murray", "Tomas Berdych", "Juan Martin Del Potro"};
        List<String> players = Arrays.asList(atp);

// Old looping
        for (String player : players) {
            System.out.print(player + "; ");
        }
        
        System.out.println("\n-------------------------------------");

// Using lambda expression and functional operations
        players.forEach((player) -> System.out.print(player + "; "));
        
        System.out.println("\n-------------------------------------");

// Using double colon operator in Java 8
        players.forEach(System.out::println);
        
        System.out.println("\n-------------------------------------");

// Sort players by name using anonymous innerclass
        
        /* Arrays.sort(atp, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s1.compareTo(s2));
            }
        }); */
        
        // Sort players by surname using lambda expression
        Comparator<String> sortBySurname = (String s1, String s2) -> (s1.substring(s1.indexOf(" ")).compareTo(s2.substring(s2.indexOf(" "))));

        Arrays.sort(atp, sortBySurname);
        
         List<String> playersSorted = Arrays.asList(atp);
         
         playersSorted.forEach(System.out::println);
        
        
        

    }

}
