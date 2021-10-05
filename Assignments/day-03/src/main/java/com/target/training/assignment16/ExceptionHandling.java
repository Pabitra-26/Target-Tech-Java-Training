package com.target.training.assignment16;



import com.target.training.utils.KeyboardUtil;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionHandling {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> integerArray = new ArrayList<Integer>();

        String integers = new String();
        String nonIntegers = new String();
        int nonIntegersCount = 0;

        while (true) {

            String acceptance = KeyboardUtil.getString("Do you want to enter a number: ");

            if (acceptance.equals("YES")) {

                try {
                    int num1;
                    num1 = KeyboardUtil.getInt("Enter a number: ");
                    integerArray.add(num1);
                    if (integers.length() == 0) {
                        integers += Integer.toString(num1);
                    } else {
                        integers += (", " + Integer.toString(num1));
                    }

                } catch (InputMismatchException e) {
                    try {
                        String num2 = KeyboardUtil.getString("Enter the number again: ");

                        if (nonIntegers.length() == 0) {
                            nonIntegers += num2;
                        } else {
                            nonIntegers+= (", ".concat(num2));
                        }
                        nonIntegersCount+=1;

                    } catch (InputMismatchException ex) {
                        double num3 = KeyboardUtil.getDouble("Enter the number again: ");

                        if (nonIntegers.length() == 0) {
                            nonIntegers += Double.toString(num3);
                        } else {
                            nonIntegers += (", " .concat(Double.toString(num3)));
                        }
                        nonIntegersCount+=1;

                    }
                }
            } else {
                int sum = 0;
                for (int i = 0; i < integerArray.size(); i++) {
                    sum += integerArray.get(i);
                }

                System.out.printf("Number of inputs = %d\n" +
                                "Number of integer inputs = %d\n" +
                                "Number of non-integer inputs = %d\n" +
                                "Sum of all integer inputs = %d\n" +
                                "The integer inputs = %s\n" +
                                "The non-integer inputs = %s\n" +
                                "%d, %d, %d, etc should be actual values, based on the inputs.\n", (integerArray.size() + nonIntegersCount),
                        integerArray.size(), nonIntegersCount, sum, integers, nonIntegers,(integerArray.size() + nonIntegersCount),
                        integerArray.size(), nonIntegersCount);

                break;

            }


        }
    }
}
