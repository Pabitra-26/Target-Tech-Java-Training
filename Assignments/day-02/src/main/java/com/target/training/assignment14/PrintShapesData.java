package com.target.training.assignment14;

public class PrintShapesData {

    public static void main(String[] args) {

        Shape[] shapes = {
                new Circle(8),
                new Rectangle(4,9),
                new Square(10),
                new Circle(5),
                new Rectangle(4,5),
                new Square(4),
                new Circle("yellow",true,5),
                new Rectangle("blue",false, 4,5),
                new Square(4, "pink", true),
                new Square(6, "red", false)

        };

//        for(int i=0; i<shapes.length;i++){
//            System.out.println(shapes[i]);
//        }

//        for(int i=0;i< shapes.length;i++){
//            String className = shapes[i].getClass().getName();
//            String [] classNameArray = className.split("[.]");
//            String name = classNameArray[classNameArray.length-1];
//
//            if(name.equals("Circle")){
//                System.out.println("Perimeter and area of " + name +" are "+ ((Circle)shapes[i]).getPerimeter() + " and " + ((Circle)shapes[i]).getArea() + " respectively.");
//            }
//            else if(name.equals("Rectangle")){
//              System.out.println("Perimeter and area of " + name + " are "+ ((Rectangle)shapes[i]).getPerimeter() + " and " + ((Rectangle)shapes[i]).getArea() + " respectively.");
//            }
//            else if(name.equals("Square")){
//              System.out.println("Perimeter and area of " + name + " are "+ ((Square)shapes[i]).getPerimeter() + " and " + ((Square)shapes[i]).getArea() + " respectively.");
//            }
//        }
        for(int i=0;i< shapes.length;i++){
            if(shapes[i] instanceof Circle){
                System.out.println("Perimeter and area of Circle are "+ ((Circle)shapes[i]).getPerimeter() + " and " +  ((Circle)shapes[i]).getArea() + " respectively.");
            }
            else if(shapes[i] instanceof Rectangle){
                System.out.println("Perimeter and area of Rectangle are "+ ((Rectangle)shapes[i]).getPerimeter() + " and " + ((Rectangle)shapes[i]).getArea() + " respectively.");
            }
            else if(shapes[i] instanceof Square){
                System.out.println("Perimeter and area of Square are "+ ((Square)shapes[i]).getPerimeter() + " and " + ((Square)shapes[i]).getArea() + " respectively.");
            }
        }
    }
}
