package com.target.training.assignment14;

public class Circle extends Shape{

    private double radius = 1.0;
    static public double pi = 3.1416;


    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(String color, boolean filled, double radius) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea(){
        return pi*getRadius()*getRadius();
    }

    public double getPerimeter(){
        return 2*pi*getRadius();
    }

    @Override
    public String toString() {
        return "A Circle with radius= " + getRadius()+ " ,which is a subclas of "+super.toString();
    }
}
