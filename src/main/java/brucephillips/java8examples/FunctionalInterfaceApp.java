/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brucephillips.java8examples;

/**
 * See: http://winterbe.com/posts/2014/03/16/java-8-tutorial/
 * @author brucephillips
 */
public class FunctionalInterfaceApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Converter<String, Integer> converter = Integer::valueOf;

        Integer convertedInt = converter.convert("123");

        System.out.println(convertedInt);   // 123

        StringUtils stringUtils = new StringUtils();

        Converter<String, String> converter2 = stringUtils::startsWith;

        String convertedStr = converter2.convert("Java");

        System.out.println(convertedStr);    // "J"

        PersonFactory<Person> personFactory = Person::new;
        
        Person person = personFactory.create("Peter", "Parker");
        
        System.out.println(person);

    }

}
