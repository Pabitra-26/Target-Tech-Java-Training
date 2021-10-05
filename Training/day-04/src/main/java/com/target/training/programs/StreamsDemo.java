package com.target.training.programs;

import java.util.Arrays;
import java.util.List;

public class StreamsDemo {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("Pabbi", "Anurag", "Arpita", "Komal", "Krishanu");
        System.out.println(names.getClass().getName());

        for(String name: names){
            System.out.println(name);
        }
        System.out.println();

        names.stream()
                .filter(name -> name.startsWith("A"))
                .map(name -> name.toUpperCase())
                .forEach(System.out::println);
    }
}
