package com.target.training.programs.assignment9;


import com.target.training.util.KeyboardUtil;

import java.util.Scanner;

public class EvenAndOdd {
    public static int[] sumOfEvensAndOdds(int []nums) {
        int evenSum = 0;
        int oddSum = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==0){
                evenSum+=nums[i];
            }
            else{
                oddSum+=nums[i];
            }
        }
        int [] result = {evenSum,oddSum};
        // do stuff here
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int index = 0;
        index = KeyboardUtil.getInt("Enter the index value: ");
        int [] nums = new int[index];
        for(int i=0; i<index;i++){
            nums[i] = sc.nextInt();
        }
        int[] result = sumOfEvensAndOdds(nums);
        System.out.println("First element in the result array: "+result[0]);
        System.out.println("Second element in the result array: "+result[1]);



    }

}
