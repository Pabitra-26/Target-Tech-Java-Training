package com.target.training.programs;

import java.util.Arrays;

public class CatchWithMultipleExceptionsDemo {

    public static void main(String[] args) {

        try{
            String s1 = "100";
            String s2 = "0";

            int num = Integer.parseInt(s1);
            int den = Integer.parseInt(s2);

            int quotient = num / den;

            System.out.printf("Quotient of %d divided by %d is %d\n", num, den, quotient);
        }
        catch (ArrayIndexOutOfBoundsException | NumberFormatException e){
            System.out.printf("Expected 2 integers but received %s", Arrays.toString(args));

        }
        catch(ArithmeticException e){
            System.out.println("Cannot divide integer by 0");
        }
        catch(Exception e){
            System.out.println("Something went wrong!");
        }
        System.out.println("This is the end of the program.");
    }
}
