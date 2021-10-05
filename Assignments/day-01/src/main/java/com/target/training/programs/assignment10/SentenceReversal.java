package com.target.training.programs.assignment10;


import com.target.training.util.KeyboardUtil;

public class SentenceReversal {
    public static String reverseByWords(String sentence) {

        String [] array = sentence.split(" ");
        String reversed = "";
        for(int i=array.length-1;i>=0;i--){
            reversed+=array[i];
            reversed+=" ";
        }

        return reversed;
    }

    public static void main(String[] args) {

        String sentence = KeyboardUtil.getString("Enter a message: ");

        String reversedSentence = reverseByWords(sentence);
        System.out.println(reversedSentence);

    }

}
