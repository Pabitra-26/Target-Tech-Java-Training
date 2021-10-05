package com.target.training.programs;

import com.target.training.entity.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortingPersonsDemo {

    static class AgeComparator implements Comparator<Person>{
        @Override
        public int compare(Person o1, Person o2) {
            return o1.getAge() <= o2.getAge() ? -1:1;
        }
    }

    public static void main(String[] args) {

        List<Person> people = new ArrayList<>();
        people.add(new Person("Vinod", 48, 5.8, "Bangalore"));
        people.add(new Person("Arunima", 20, 5.5, "Mysore"));
        people.add(new Person("Naveen", 48, 5.9, "Mangalore"));
        people.add(new Person("Arun", 48, 5.8, "Bangalore"));
        people.add(new Person("Ramesh", 44, 5.8, "Delhi"));
        people.add(new Person("Mahesh", 52, 5.7, "Bangalore"));
        people.add(new Person("Arunima", 20, 5.5, "Kolkata"));
        people.add(new Person("Arunima", 18, 5.3, "Hyderabad"));

        printPeople(people);
        Collections.sort(people);
        printPeople(people);
        Collections.sort(people, new AgeComparator());
        printPeople(people);
        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getHeight() <= o2.getHeight() ? -1:1;
            }
        });
        printPeople(people);
        Collections.sort(people, (o1, o2) -> o1.getCity().compareTo(o2.getCity()) <= 0? -1:1);
        printPeople(people);


    }

    static void printPeople(List<Person> people){
        for(Person p : people){
            System.out.println(p);
        }
        System.out.println();
    }
}
