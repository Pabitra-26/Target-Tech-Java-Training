package com.target.training.programs;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PersonInfo {

    public static void main(String[] args) {

        Integer age = 12;
        Double height = 5.1;
        Double weight = 49.5;
        boolean isMarried = false;

        String name = "Pabitra Priyadarshini Jena";

        log.debug("Name:  {}", name);
        log.debug("Age:   {}", age);
        log.debug("Height: {}", height);
        log.debug("Weight: {}", weight);

        if(isMarried){
            log.debug("{} is married." , name);
        }
        else{
            log.debug("{} is not married.", name);
        }

        if(height < 5.0){
            log.debug("{} is short!", name);
        }
        else if(height >= 6.0){
            log.debug("{} is tall!", name);
        }
        else{
            log.debug("{} has an average height!", name);
        }
    }
}
