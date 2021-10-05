package com.target.training.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Person implements Comparable<Person>{
    private String name;
    private int age;
    private double height;
    private String city;

    @Override
    public int compareTo(Person o) {
        int diff = this.name.compareTo(o.name);
        if(diff == 0){
            diff = Integer.compare(this.age, o.age);
            if(diff == 0){
                diff = Double.compare(this.height, o.height);
                if(diff == 0){
                    diff = this.city.compareTo(o.city);
                }
            }
        }
        return diff;
    }
}
