package com.target.training.programs.assignment1;


import com.target.training.util.KeyboardUtil;

public class ValidDate {


    static boolean isValidDate(int year, int month, int day) {
        boolean isLeapYear = false;
        if(year%400==0){
            isLeapYear=true;
        }
        else if(year%100==0){
            isLeapYear=false;
        }
        else if(year%4==0){
            isLeapYear=true;
        }
        if(month>=1 && month<=12){
            if(month==2) {
                if (isLeapYear) {
                    if (day >= 1 && day <= 29) {
                        return true;
                    }
                } else {
                    if (day >= 1 && day <= 28) {
                        return true;
                    }


                }
            }
            else if(month==1 || month ==3 || month ==5 || month ==7 || month==8 || month==10 || month==12){
                if(day>=1 && day<=31){
                    return true;
                }
            }
            else{
                if(day>=1 && day<=30){
                    return true;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {

        int year, month, day;

        year = KeyboardUtil.getInt("Enter year: ");
        month = KeyboardUtil.getInt("Enter month: ");
        day = KeyboardUtil.getInt("Enter day: ");

        boolean result = isValidDate(year, month, day);
        if (result == true) {
            System.out.println(day + "-" + month + "-" + year + " is a valid date.");
        } else {
            System.out.println(day + "-" + month + "-" + year + " is an invalid date.");
        }
    }

}
