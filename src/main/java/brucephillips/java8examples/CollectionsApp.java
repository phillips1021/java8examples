/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brucephillips.java8examples;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.function.Predicate;
import java.util.function.Function;
import java.util.Optional;


/**
 *
 * @author brucephillips
 */
public class CollectionsApp {

    private final static List<String> friends
            = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");

    public static void main(String[] args) {

        friends.forEach(name -> System.out.print(name + " "));

        System.out.println();

        friends.stream().map(name -> name.toUpperCase()).forEach(name -> System.out.print(name + " "));

        System.out.println();

        final List<String> startsWithN = friends.stream().filter(name -> name.startsWith("N")).collect(Collectors.toList());

        startsWithN.forEach(name -> System.out.print(name + " "));

        System.out.println();

        final Predicate<String> startsWithNPred = name -> name.startsWith("N");

        final long countFriends = friends.stream().filter(startsWithNPred).count();

        System.out.println("Number of friends start with N is " + countFriends);

        final Function<String, Predicate<String>> startsWithLetter
                = (String letter) -> {
                    Predicate<String> checkStarts = (String name) -> name.startsWith(letter);
                    return checkStarts;
                };

        final long countFriendsB = friends.stream().filter(startsWithLetter.apply("B")).count();

        System.out.println("Number of friends start with B is " + countFriendsB);
        
        final String startingLetter = "S";
        
        final Optional<String> foundName = friends.stream().filter(name -> name.startsWith(startingLetter)).findFirst() ;
        
        System.out.println( String.format("A name starting with %s: %s", startingLetter, foundName.orElse("No name found"))) ;

    }

}
