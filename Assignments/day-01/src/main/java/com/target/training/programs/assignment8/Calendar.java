package com.target.training.programs.assignment8;


import com.target.training.util.KeyboardUtil;

public class Calendar {

    public static boolean leapYear(int year) {
        boolean isLeapYear = false;
        if (year % 400 == 0) {
            isLeapYear = true;
        } else if (year % 100 == 0) {
            isLeapYear = false;
        } else if (year % 4 == 0) {
            isLeapYear = true;
        }
        return isLeapYear;

    }

    public static void  printCalendar(int month, int year){


        int monthCode = 0;
        switch(month){

            case 1: monthCode = 0;
                break;

            case 2: monthCode = 3;
                break;

            case 3: monthCode = 3;
                break;

            case 4: monthCode = 6;
                break;

            case 5: monthCode = 1;
                break;

            case 6: monthCode = 4;
                break;

            case 7: monthCode = 6;
                break;

            case 8: monthCode = 2;
                break;

            case 9: monthCode = 5;
                break;

            case 10: monthCode = 0;
                break;

            case 11: monthCode = 3;
                break;

            case 12: monthCode = 5;
                break;
        }

        int yearCode = 0;
        if(year>=1600 && year<=1699){
            yearCode = 6;
        }
        else if(year>=1700 && year<=1799){
            yearCode = 4;
        }
        else if(year>=1800 && year<=1899){
            yearCode = 2;
        }
        else if(year>=1900 && year<=1999){
            yearCode = 0;
        }
        else if(year>=2000 && year<=2099){
            yearCode = 6;
        }

        int onesDigit = year%10 ;

        int tensDigit = year%100;

        int lastTwoDigit = tensDigit;

        int dayCalculation = (lastTwoDigit + (lastTwoDigit/4) + 1 + monthCode + yearCode) % 7;
//
        int nRows = 0;
        if((31 + dayCalculation)%7 !=0){
            nRows = ((31 + dayCalculation)/7) +1 ;
        }
        else{
            nRows = (31 + dayCalculation)/7;
        }

        int nDays = 31;

        if(month==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12){
            nDays = 31;
        } else if (month==2){
            if(leapYear(year)){
                nDays = 29;
            }
            else{
                nDays = 28;
            }
        }
        else{
            nDays = 30;
        }


        int [][]calendarArray = new int[nRows][7];
        int count = 1;
        boolean startedDate = false;
        for(int i=0;i<nRows;i++){
            for(int j=0;j<7;j++){
                if(i==0){
                    if(dayCalculation!=j && startedDate==false){
                        calendarArray[i][j] = 0;
                    }
                    else{
                        calendarArray[i][j] = count++;
                        startedDate = true;

                    }
                }
                else{
                    if(count<= nDays){
                        calendarArray[i][j] = count++;
                    }
                    else{
                        calendarArray[i][j] = 0;
                        count++;
                    }

                }
            }
        }

        System.out.println("Su " + "Mo " + "Tu " + "We " + "Th " + "Fr " + "Sa ");
        for(int i =0; i<calendarArray.length; i++){
            for(int j=0; j<calendarArray[i].length; j++){
                String date ="   ";
                if(calendarArray[i][j] ==0){
                    System.out.printf(date);
                }
                else{
                    if(calendarArray[i][j]/10==0){
                        System.out.printf(" %d ", calendarArray[i][j]);
                    }
                    else{
                        System.out.printf("%d ", calendarArray[i][j]);
                    }

                }

            }
            System.out.println();
        }






    }

    public static void main(String[] args) {

        int month = KeyboardUtil.getInt("Enter the month: ");
        int year = KeyboardUtil.getInt("Enter the year: ");

        Calendar c1 = new Calendar();
        c1.printCalendar(month, year);


    }
}
