package com.target.training.programs;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HelloWorld {

    static void sayHello(){
        log.debug("Hello, world!");
    }

    static void welcome(){
        log.debug("Welcome to Java Programming at Target Corporation!!!");
    }

    public static void main(String[] args) {

        log.debug("Start of main");
        sayHello();
        welcome();
        welcome();
        welcome();
        sayHello();
        log.debug("End of main");
    }
}
