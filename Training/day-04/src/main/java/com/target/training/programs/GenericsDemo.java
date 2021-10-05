package com.target.training.programs;

import com.target.training.entity.Circle;

public class GenericsDemo {

    public static void main(String[] args) {

        Circle<Double> c1 = new Circle<Double>();
        c1.setRadius(12.0);

        Circle<Integer> c2 = new Circle<Integer>();
        c2.setRadius(12);

        Circle<String> c3;
        c3 = new Circle<>();
        c3.setRadius("12");

        System.out.println(c1.getRadius());
        System.out.println(c2.getRadius());
        System.out.println(c3.getRadius());
    }
}
