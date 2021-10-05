package com.target.training.programs.assignment2;


import com.target.training.util.KeyboardUtil;

public class PrimeNumber {

    static boolean isPrimeNumber(int num) {

        if(num<=1){
            return false;
        }
        for(int i =2; i<=Math.sqrt(num);i++){
            if(num%i==0){
                return false;
            }
        }
        // do stuff here
        return true;
    }

    public static void main(String[] args) {

        int number;
        number = KeyboardUtil.getInt("Enter a number: ");
        if(isPrimeNumber(number)==true){
            System.out.println(number+" is a prime number.");
        }
        else{
            System.out.println(number+" is not a prime number.");
        }
    }

}
