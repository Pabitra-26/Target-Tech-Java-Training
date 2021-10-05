package com.target.training.assignment17;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor


public class Calendar {

    private String date;

    public void setDate(String date){
        String [] dateArray = date.split("-");
        int month = Integer.parseInt(dateArray[1]);

        if(dateArray[0].length()==4 && dateArray[1].length()==2){

        }
        else{
            throw new InvalidInputException("Date is not entered in the current format.");
        }

        if(!(month>=1 && month<=12)){

            throw new InvalidDateException("Invalid Date!");
        }

        this.date = date;

    }

    public boolean leapYear(int year) {
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

    public int[][] calendar(String date){
        String [] dateArray = date.split("-");
        String month = dateArray[1];
        int monthNumber = Integer.parseInt(dateArray[1]);
        int year = Integer.parseInt(dateArray[0]);

        int onesDigit = year%10 ;
//        System.out.println(onesDigit);
        int tensDigit = year%100;
//        System.out.println(tensDigit);
        int lastTwoDigit = tensDigit;

        int monthCode = 0;
        switch(month){

            case "01": monthCode = 0;
            break;

            case "02": monthCode = 3;
                break;

            case "03": monthCode = 3;
                break;

            case "04": monthCode = 6;
                break;

            case "05": monthCode = 1;
                break;

            case "06": monthCode = 4;
                break;

            case "07": monthCode = 6;
                break;

            case "08": monthCode = 2;
                break;

            case "09": monthCode = 5;
                break;

            case "10": monthCode = 0;
                break;

            case "11": monthCode = 3;
                break;

            case "12": monthCode = 5;
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

        int dayCalculation = (lastTwoDigit + (lastTwoDigit/4) + 1 + monthCode + yearCode) % 7;
//        System.out.println(lastTwoDigit+" "+ (lastTwoDigit/4)+" "+monthCode+" "+yearCode);
//        System.out.println(dayCalculation);
         int nRows = 0;
        if((31 + dayCalculation)%7 !=0){
            nRows = ((31 + dayCalculation)/7) +1 ;
        }
        else{
            nRows = (31 + dayCalculation)/7;
        }

        int nDays = 31;

        if(month.equals("01") || month.equals("03") || month.equals("05") || month.equals("07") || month.equals("08") || month.equals("10") || month.equals("12")){
            nDays = 31;
        } else if (month.equals("02")){
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
//        System.out.println(nDays + " "+ year+" "+dayCalculation);

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

//        System.out.println(calendarArray.toString());

        return calendarArray;
    }

}
