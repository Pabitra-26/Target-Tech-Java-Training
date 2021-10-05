package com.target.training.assignment14;

public class Square extends Rectangle{

    public Square() {
    }
    public Square(double side){

    }
    public Square(double side, String color, boolean filled){
        setSide(side);
        super.setColor(color);
        super.setFilled(filled);
    }

    public double getSide(){
        return super.getWidth();
    }

    public void setSide(double side){
        setWidth(side);
        setLength(side);
    }

    public void setWidth(double side){
        super.setWidth(side);
    }

    public void setLength(double side){
        super.setLength(side);
    }



    @Override
    public String toString() {
        return "A Square with side= "+getSide()+", which is a subclass of "+super.toString();
    }
}
