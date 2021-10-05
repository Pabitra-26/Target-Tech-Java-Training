package com.target.training.programs;

import com.target.training.model.Person;

public class PrintPersonData {
    public static void main(String[] args) {

        Person p1;
        p1 = new Person();
        p1.setName("Pabbi");
        p1.setAge(22);
        p1.setHeight(5.0);

        p1.print();

        System.out.println(p1);
        System.out.println(p1.toString());
    }
}
