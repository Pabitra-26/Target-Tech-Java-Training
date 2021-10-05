package com.target.training.programs.assignment5;


import com.target.training.util.KeyboardUtil;

public class FibonacciSeries {

    public int fibonacci(int index) {

        if(index<=1){
            return index;
        }
        else{
            return fibonacci(index-1)+fibonacci(index-2);
        }


    }

    public static void main(String[] args) {
        FibonacciSeries fib = new FibonacciSeries();
        int index;
        index = KeyboardUtil.getInt("Enter index value: ");
        int result = fib.fibonacci(index);
        System.out.println(result);
    }

}
