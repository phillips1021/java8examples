/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brucephillips.java8examples;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * See: http://www.programcreek.com/2014/01/create-stream-in-java-8/
 *
 * @author brucephillips
 */
public class StreamExampleApp {

    public static void main(String[] args) {

        /*
         Different ways to create a Stream
         */
        String[] arr = {"program", "creek", "program", "creek", "java", "web",
            "program"};
        Stream stream = Stream.of(arr);
        stream.forEach(name -> System.out.println(name));

        String[] stringArr = {"a", "b", "c", "d"};
        Stream<String> stream2 = Arrays.stream(stringArr);
        stream2.forEach(name -> System.out.println(name));

        List<String> list = new ArrayList<>();
        list.add("java");
        list.add("php");
        list.add("python");
        Stream stream3 = list.stream();
        stream3.forEach(name -> System.out.println(name));
        
        //map function
	Stream<Integer> stream3Map = list.stream().map(p -> p.length());
        stream3Map.forEach(name -> System.out.println(name));
        
        //filter function
        Stream<String> stream3Filter = list.stream().filter(p -> p.length() > 3);
        stream3Filter.forEach(name -> System.out.println(name));

        // generate() - create 10 "test" Strings in the Stream
        Stream<String> stream4 = Stream.generate(() -> "test").limit(10);
        stream4.forEach(name -> System.out.println(name));
       

        // iterate() create Stream of BigInteger objects 1 to 9
        Stream<BigInteger> bigIntStream = Stream.iterate(BigInteger.ZERO, n -> n.add(BigInteger.ONE)).limit(10);
        bigIntStream.forEach(name -> System.out.println(name));
         
        // stream method from APIs
        String sentence = "Program creek is a Java site.";
        Stream<String> wordStream = Pattern.compile("\\W").splitAsStream(sentence);
        wordStream.forEach(name -> System.out.println(name));


    }

}
