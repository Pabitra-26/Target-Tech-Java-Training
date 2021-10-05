package com.target.training.programs;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class ReadingPropertiesFromFIleDemo {

    public static void main(String[] args) {

        try(FileReader reader = new FileReader("pabbi.properties");) {
            Properties props = new Properties();
            props.load(reader);
            System.out.println(props);
            Set<Map.Entry<Object, Object>> entries = props.entrySet();
            for(Map.Entry<Object, Object> entry: entries){
                System.out.println(entry.getKey()+"--->"+entry.getValue());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
