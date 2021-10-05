package com.target.training.programs;

import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class SetDemo {

    public static void main(String[] args) {

        Set<String> names = new TreeSet<>();
        names.add("Pabbi");
        names.add("Vinod");
        names.add(new String("Pabbi"));
        names.add("Naveen");
        names.add("Ramesh");
        names.add(new String("Pabbi"));
        names.add("Arpita");

        System.out.println("Size: " + names.size());
        System.out.println("Content: " + names);
    }
}
