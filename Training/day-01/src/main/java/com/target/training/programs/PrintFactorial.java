package com.target.training.programs;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PrintFactorial {

    public static void main(String[] args) {

        Integer num = 5;
        Integer fact = 1;

        while (num > 1){
            fact *= num--;
        }

        log.debug("Factorial is "+ fact);
    }
}
