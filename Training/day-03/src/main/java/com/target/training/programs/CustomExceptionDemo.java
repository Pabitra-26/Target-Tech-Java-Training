package com.target.training.programs;

import com.target.training.model.Employee;
import com.target.training.model.EmptyOrNullNameException;
import com.target.training.model.InvalidException;

public class CustomExceptionDemo {
    public static void main(String[] args) throws EmptyOrNullNameException, InvalidException {

        Employee e1;
        e1 = new Employee();
        e1.setName("Pabbi");
        e1.setId(-888);
        e1.setSalary(-4500.0);

        System.out.println(e1);
    }
}
