package com.target.training.programs;

import com.target.training.entity.Customer;
import com.target.training.entity.Gender;

public class EnumDemo {
    public static void main(String[] args) {

        Customer c1 = new Customer();
        c1.setName("Pabbi");
        c1.setGender(Gender.FEMALE);

        if(c1.getGender() == Gender.MALE){
            System.out.println("Hello, Mr." + c1.getName());
        }
        else{
            System.out.println("Hello, Ms." + c1.getName());
        }
        System.out.println(c1);
    }
}
