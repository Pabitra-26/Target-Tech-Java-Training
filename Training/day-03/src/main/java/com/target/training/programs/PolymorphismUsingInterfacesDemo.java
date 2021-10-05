package com.target.training.programs;

import com.target.training.model.Circle;
import com.target.training.model.Shape;
import com.target.training.model.Triangle;

public class PolymorphismUsingInterfacesDemo {
    public static void main(String[] args) {

        Circle c1 = new Circle(12.34);
        Triangle t1 = new Triangle(12,34);

        printInfoAboutShape(c1);
        printInfoAboutShape(t1);

    }
    static void printInfoAboutShape(Shape shape){
        System.out.println("Area of " + shape.getTypeName()+ " is " + shape.getArea() + " sq.units.");
    }
}
