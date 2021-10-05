package com.target.training.programs.assignment4;


import com.target.training.util.KeyboardUtil;

public class PrimeNumbersSum {

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

    public int sumOfPrimes(int from, int to) {
        int sum = 0;
        for(int i = from;i<=to;i++){
            if(isPrimeNumber(i)==true){
                sum+=i;
            }
        }
        // do stuff here
        System.out.println("Sum of prime numbers is: "+sum);
        return 0;
    }

    public static void main(String[] args) {
        int from, to;
        from = KeyboardUtil.getInt("Enter first number: ");
        to = KeyboardUtil.getInt("Enter second number: ");
        PrimeNumbersSum result = new PrimeNumbersSum();
        result.sumOfPrimes(from, to);
    }

}
