package com.target.training.programs;

import com.target.training.entity.Person;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetOfPersonsDemo {

    public static void main(String[] args) {

        Set<Person> people = new HashSet<>();
        Person p;
        p = new Person("Vinod", 48, 5.8, "Bangalore");
        System.out.println(p.hashCode());
        people.add(p);
        p = new Person("Vinod", 46, 6.2, "Delhi");
        System.out.println(p.hashCode());
        people.add(p);
        p = new Person("Vinod", 48, 5.8, "Bangalore");
        System.out.println(p.hashCode());
        people.add(p);
        p = new Person("Vinod", 48, 5.9, "Bangalore");
        System.out.println(p.hashCode());
        people.add(p);

        System.out.println(people.size());

        Iterator<Person> it = people.iterator();
        while(it.hasNext()){
            Person p1 = it.next();
            System.out.println(p1);
        }
    }
}
