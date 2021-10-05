package com.target.training.programs;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PrintTable {

    public static void main(String[] args) {

        int num = 56;

        for(int i=1; i<=10; i++){
            log.debug("{} * {} = {}", num, i, num*i);
        }
    }
}
