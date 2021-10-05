package com.target.training.programs;

import com.target.training.model.DummyResource;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResourcesDemo {
    public static void main(String[] args) {

        String filename ="src/main/java/com/target/training/model/Circle.java";

        try(
                DummyResource dr = new DummyResource();
                FileReader reader = new FileReader(filename);
                BufferedReader in = new BufferedReader(reader);
                ){

            dr.doStuff();
            String line;
            while((line = in.readLine())!=null){
                System.out.println(line);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
