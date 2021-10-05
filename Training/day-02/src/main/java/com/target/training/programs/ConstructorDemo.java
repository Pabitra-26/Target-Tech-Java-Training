package com.target.training.programs;

import com.target.training.model.Person;

public class ConstructorDemo {

    public static void main(String[] args) {

        Person p1 = new Person();
        Person p2 = new Person("Arun", 47, 5.6);

        p1.setName("Pabbi");
        p1.setAge(23);
        p1.setHeight(5.2);
        System.out.println(p1);
        System.out.println(p2);
    }
}
