/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brucephillips.java8examples;

/**
 *
 * @author brucephillips
 */
public class StringApp {

    public static void main(String[] args) {

        final String str = "w00t";

        str.chars()
                .forEach(letter -> System.out.println(letter));

        str.chars()
                .mapToObj(ch -> Character.valueOf((char) ch)).forEach(System.out::println);

        str.chars()
                .filter(ch -> Character.isDigit(ch)).forEach(ch -> System.out.println(ch));

    }

}
