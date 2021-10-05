package com.target.training.model;

public class Person {
    private String name;
    private int age;
    private double height;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0 && age <= 150) {
            this.age = age;
        }
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        if (height > 0 && height <= 8) {
            this.height = height;
        }
    }

    public Person() {
    }

    public Person(String name, int age, double height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Object of Person with values {" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                '}';
    }

    public void print(){
        System.out.println("Name   = " + name);
        System.out.println("Age    = " + age + " years");
        System.out.println("Height = " + height + " ft.");
        System.out.println();

    }
}
