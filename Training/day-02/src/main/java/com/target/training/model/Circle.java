package com.target.training.model;

public class Circle {
    public double radius;
    public static double pi = 3.1416;

    public void printArea(){
        double area = pi*radius*radius;
        System.out.println("Area of circle with radius " + radius +
                " is " + area + " sq.units");
    }
}
