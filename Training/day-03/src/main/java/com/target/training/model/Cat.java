package com.target.training.model;

public class Cat extends Animal{

    @Override
    public void info() {
        System.out.println("Cat class created by Pabitra");
    }

    @Override
    public void talk() {
        System.out.println("Cat says meow...");

    }

    @Override
    public String getAuthor() {
        return "Pabitra";
    }

    public void phurr(){
        System.out.println("Cat is in a lazy mood and phurring...");
    }
}
