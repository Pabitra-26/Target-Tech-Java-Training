package com.target.training.programs;

import java.util.Arrays;

public class MultipleCatchesDemo {

    public static void main(String[] args) {

        try{
            String s1 = "100";
            String s2 = "0";

            int num = Integer.parseInt(s1);
            int den = Integer.parseInt(s2);

            int quotient = num/den;

            System.out.printf("Quotient of % divided by %d is %d\n", num, den, quotient);
        }
        catch(ArithmeticException e){
            System.out.println("Cannot divide integer by 0");
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.printf("Expected 2 inputs, got %d inputs\n", args.length);
        }
        catch (NumberFormatException e){
            System.out.printf("Expected 2 integers but received %s\n", Arrays.toString((args)));
        }
        catch(Exception e){
            System.out.println("SOmething went wrong!");
        }

        System.out.println("This is the ned of the program");
    }
}
