/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brucephillips.java8examples;

import java.util.Arrays;
import static java.util.Comparator.comparing;
import java.util.List;
import java.util.function.Function;
import static java.util.stream.Collectors.toList;

/**
 *
 * @author brucephillips
 */
public class ComparatorApp {

    public static void main(String[] args) {

        final List<Person> people = Arrays.asList(
                new Person("John", "Smith", 20),
                new Person("Sara", "Smith", 21),
                new Person("Jane", "Smith", 21),
                new Person("Greg", "Smith", 35));

        List<Person> ascendingAge
                = people.stream()
                .sorted((person1, person2) -> person1.ageDifference(person2))
                .collect(toList());

        printPeople("Sorted in ascending order by age: ", ascendingAge);

        final Function<Person, Integer> byAge = person -> person.getAge();
        
        final Function<Person, String> byTheirName = person -> person.getFirstName();
        
        printPeople("Sorted in ascending order by age and name: ", people.stream()
                .sorted(comparing(byAge).thenComparing(byTheirName))
                .collect(toList()));

    }

    public static void printPeople(
            final String message, final List<Person> people) {

        System.out.println(message);
        people.forEach(System.out::println);
    }

}
