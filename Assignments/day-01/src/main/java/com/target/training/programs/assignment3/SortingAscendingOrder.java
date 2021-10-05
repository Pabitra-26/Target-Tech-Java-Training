package com.target.training.programs.assignment3;


import com.target.training.util.KeyboardUtil;

public class SortingAscendingOrder {

    public void sortThreeNumbers(int a, int b, int c) {
        int first,second, third;
        if(a<b && a<c){
            first = a;
            if(b<c){
                second = b;
                third = c;
            }
            else{
                second = c;
                third = b;
            }
            System.out.println("Ascending order: "+first+" , "+second+" , "+third);
        }

        else if(b<a && b<c){
            first = b;
            if(a<c){
                second = a;
                third = c;
            }
            else{
                second = c;
                third = a;
            }
            System.out.println("Ascending order: "+first+" , "+second+" , "+third);
        }
        else{
            first = c;
            if(a<b){
                second = a;
                third = b;
            }
            else{
                second = b;
                third = a;
            }
            System.out.println("Ascending order: "+first+" , "+second+" , "+third);

        }

    }

    public static void main(String[] args) {

        int a,b,c;
        a = KeyboardUtil.getInt("Enter first number: ");
        b = KeyboardUtil.getInt("Enter second number: ");
        c = KeyboardUtil.getInt("Enter third number: ");
        SortingAscendingOrder sortNumbers = new SortingAscendingOrder();
        sortNumbers.sortThreeNumbers(a,b,c);




    }




}
