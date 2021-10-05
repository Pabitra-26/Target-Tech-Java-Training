package com.target.training.assignment17;



import com.target.training.utils.KeyboardUtil;

import java.util.Arrays;

public class PrintCalendarData {

    public static void main(String[] args) {

        Calendar c1 = new Calendar();
        String inputDate = KeyboardUtil.getString("Enter a date in \"YYYY-MM\" format strictly: ");

        try{
            c1.setDate(inputDate);
            int [][] calendar = c1.calendar(inputDate);

            for(int i=0;i< calendar.length;i++){
                System.out.println(Arrays.toString(calendar[i]));
            }
        }
        catch(InvalidDateException e){
            System.out.println(e.getMessage());
        }
        catch (InvalidInputException ex){
            System.out.println(ex.getMessage());
        }





    }
}
