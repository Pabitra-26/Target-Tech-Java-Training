package com.target.training.programs;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapDemo {

    public static void main(String[] args) {

        Map<String, String> friends = new HashMap<>();
        friends.put("Vinay", "Hassan");
        friends.put("Shyam", "Shivamogga");
        friends.put("Nived", "Nagpur");
        friends.put("Nimesh", "Newzealand");
        friends.put("Naveen", "Bangalore");
        friends.put("Arun", "Bangalore");
        friends.put("Nived", "Hyderabad");


        System.out.println(friends);
        String name = "Naresh";
        if(friends.containsKey(name)){
            System.out.println(name + " lives in " + friends.get(name));
        }
        else{
            System.out.println(name + " is not in your friend list");
        }

        Set<String> keys = friends.keySet();
        System.out.println("Keys are: ");
        for(String key: keys){
            System.out.println(key);
        }
        System.out.println();

        Collection<String> values = friends.values();
        System.out.println("Values are: ");
        for(String value: values){
            System.out.println(value);
        }
        System.out.println();

        Set<Map.Entry<String, String>> entries = friends.entrySet();
        System.out.println("Entries are: ");
        for(Map.Entry<String, String> entry: entries){
            System.out.println(entry.getKey()+" ---> "+ entry.getValue());
        }
    }
}
