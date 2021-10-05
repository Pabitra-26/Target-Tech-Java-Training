package com.target.training.programs;

public class StringDemo {


    public static void main(String[] args) {

        String n1 = "Pabbi";
        String n2 = "Pabbi";
        String n3 = new String("Pabbi");

        System.out.println("n1==n2 is " + (n1==n2));
        System.out.println("n1==n3 is " + (n1==n3));
        System.out.println("n1.equals(n3) is " + n1.equals(n3));
    }



}
