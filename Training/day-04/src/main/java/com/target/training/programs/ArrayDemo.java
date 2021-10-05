package com.target.training.programs;

public class ArrayDemo {

    static String toString(int[] arr){
        String t = "[";
        for(int i=0; i<arr.length-1;i++){
            t += arr[i]+", ";
        }
        t+=arr[arr.length-1] + "]";
        return t;
    }

    static int[] push(int[] arr, int num){
        int [] newArr = new int[arr.length+1];
        System.arraycopy(arr,0, newArr,0, arr.length);
        newArr[arr.length] = num;
        return newArr;
    }

    public static void main(String[] args) {

        int[] nums;
        nums = new int[]{12,34,56};
        System.out.println("nums is: "+toString(nums));

        nums = push(nums, 67);
        nums = push(nums, 87);

        System.out.println("nums is: " + toString(nums));
    }
}
