package com.target.training.programs.assignment7;


import com.target.training.util.KeyboardUtil;

public class SineOfAnAngle {

    static int factorial(int n){
        if(n==1){
            return n;
        }
        else{
            return n*factorial(n-1);
        }
    }

    static int power(double base, int exp){
        int result;
        result = 1;
        while(exp>0){
            result*=base;
            exp--;
        }
        return result;
    }
    static double calculateSine(double angle){
        angle = (angle*3.14)/180;
//        System.out.println(angle);
        double sum = 0;
        for(int i=0;i<5;i++){
            if(i==0){
                double numerator = angle;
                int  denominator = 1;
                sum+= (numerator/denominator);
//                System.out.println(sum);
            }
            else{
                if(i%2!=0){
                    int t1 = (2*i)+1;
                    int numerator = power(angle,t1);
                    int denominator = factorial(t1);
                    sum-=(numerator/denominator);
                }
                else{
                    if(i%2==0){
                        int t1 = (2*i)+1;
                        int numerator = power(angle,t1);
                        int denominator = factorial(t1);
                        sum+=(numerator/denominator);
                    }
                }
//                int base1 = -1;
//                int exp1 = i, exp2 = ((2*i)+1);
//                double base2 = angle;
//                double numerator =(power(base1,exp1)*power(base2,exp2));
//                int denominator = factorial((2*i)+1);
//                sum+= (numerator/denominator);
            }
        }
        return sum;

    }

    public static void main(String[] args) {

        double angle = KeyboardUtil.getDouble("Enter an angle: ");
        double sine = calculateSine(angle);
        System.out.println("Sine of "+angle+" is "+sine);


    }
}
