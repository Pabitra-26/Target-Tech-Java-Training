package com.target.training.assignment15;

public class MovableTest {

    public static void main(String[] args) {

        Movable m1 = new MovablePoint(5, 6, 10, 15);     // upcast
        System.out.println((MovablePoint)m1);
        ((MovablePoint)m1).moveLeft();
        System.out.println((MovablePoint)m1);

        Movable m2 = new MovableCircle(1, 2, 3, 4, 20);  // upcast
        System.out.println((MovableCircle)m2);
        ((MovableCircle)m2).moveRight();
        System.out.println((MovableCircle)m2);


        Movable m3 = new MovableRectangle(1, 2, 3, 4, 25, 35);  // upcast
        System.out.println((MovableRectangle)m3);
        ((MovableRectangle)m3).moveUp();
        System.out.println((MovableRectangle)m3);


    }
}
