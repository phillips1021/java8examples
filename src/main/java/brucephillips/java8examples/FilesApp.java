/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brucephillips.java8examples;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import static java.util.stream.Collectors.toList;
import java.util.stream.Stream;

/**
 *
 * @author brucephillips
 */
public class FilesApp {

    public static void main(String[] args) throws IOException {

        Files.list(Paths.get(".")).forEach(System.out::println);

        System.out.println();

        Files.list(Paths.get(".")).filter(Files::isDirectory).forEach(System.out::println);

        System.out.println();

        Files.newDirectoryStream(
                Paths.get("."), path -> path.toString().endsWith(".xml"))
                .forEach(System.out::println);

        System.out.println();

        List<File> files
                = Stream.of(new File(".").listFiles()).flatMap(file -> file.listFiles() == null
                                ? Stream.of(file) : Stream.of(file.listFiles()))
                .collect(toList());
        
        System.out.println("Count: " + files.size());

    }

}
