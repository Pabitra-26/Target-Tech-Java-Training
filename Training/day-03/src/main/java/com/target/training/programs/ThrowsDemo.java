package com.target.training.programs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ThrowsDemo {

    public static void main(String[] args) throws IOException {

        String filename = "src/main/java/com/target/training/model/Circle.java";
        FileReader reader = new FileReader(filename);
        BufferedReader in = new BufferedReader(reader);
        String line;
        while((line = in.readLine())!= null){
            System.out.println(line);
        }
    }
}
