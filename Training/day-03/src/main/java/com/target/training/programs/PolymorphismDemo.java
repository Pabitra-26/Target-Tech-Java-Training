package com.target.training.programs;

import com.target.training.model.Animal;
import com.target.training.model.Cat;
import com.target.training.model.Dog;

public class PolymorphismDemo {

    public static void main(String[] args) {

        Animal a1;

        Cat c1 = new Cat();
        Dog d1 = new Dog();

        a1 = c1;
        printAbout(a1);
        a1 = d1;
        printAbout(a1);

    }

    static void printAbout(Animal a1){
        a1.info();
        a1.talk();
        System.out.println("Authored by " + a1.getAuthor());
        if(a1 instanceof Cat){
            ((Cat) a1).phurr();
        }
        else if(a1 instanceof Dog){
            ((Dog)a1).wagTail();
        }
    }
}
