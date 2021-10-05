package com.target.training.assignment12;

public class CirclesAndCylinders {

    public static void main(String[] args) {

        Circle[] circles = {
                new Cylinder(12.34),
                new Cylinder(12.34, 10.0),
                new Cylinder(12.34, "blue", 10.0)
        };

        for(int i=0;i<circles.length;i++){
            System.out.printf("Area of circular region and the volume of cylinder %d are %f and %f respectively.\n", (i+1),((Cylinder)circles[i]).getArea(), ((Cylinder)circles[i]).getVolume());
        }


    }
}
