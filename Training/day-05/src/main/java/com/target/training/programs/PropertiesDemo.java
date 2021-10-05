package com.target.training.programs;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class PropertiesDemo {
    public static void main(String[] args) {

        Properties props = new Properties();
        props.setProperty("name", "Pabbi");
        props.setProperty("city", "Bangalore");
        props.setProperty("phone", "7259478110");
        props.setProperty("email", "pabi@gmail.com");

        try(FileWriter file = new FileWriter("pabbi.properties");){
            props.store(file, "Created on 17th september 2021");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Stored!");
        System.out.println(props);
    }
}
