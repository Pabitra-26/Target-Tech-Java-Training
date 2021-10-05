package com.target.training.model;

public class Tiger extends Animal{
    @Override
    public void info() {
        System.out.println("Tiger class by Pabbi");
    }

    @Override
    public void talk() {
        System.out.println("Tiger is saying grrr...");

    }

    @Override
    public String getAuthor() {
        return "Pabbi";
    }
}
