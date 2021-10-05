package com.target.training.programs;

import com.target.training.entity.Hello;

public class ArrowFunctionDemo {

    static void greet(Hello h, String name){
        h.sayHello(name);
        h.sayHello(name, " World!");
    }

    static void printInUpper(String str){
        System.out.println(str.toUpperCase());
    }

    public static void main(String[] args) {
        greet((name) -> System.out.println(name), "Pabbi");
        greet(System.out::println, "Arpu");
        greet(ArrowFunctionDemo::printInUpper, "Anu");
    }
}
