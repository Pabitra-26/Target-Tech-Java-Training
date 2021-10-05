package com.target.training.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class Employee {
    private int id;
    private String name;
    private double salary;

    public void setId(int id) {
        if(id<=0){
            throw new InvalidException("Invalid value for ID");
        }
        this.id = id;
    }

    public void setName(String name) {
        if(name == null || name.trim().length()==0){
            throw new EmptyOrNullNameException("Name cannot be empty or null");
        }
        this.name = name;
    }
}
