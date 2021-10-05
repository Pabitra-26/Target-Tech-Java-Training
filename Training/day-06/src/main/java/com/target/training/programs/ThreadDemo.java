package com.target.training.programs;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadDemo {


    static void print(int i){
        log.debug("Inside main, value of i is {}", i);
    }
    public static void main(String[] args) {

        Thread t1 = new Thread(){
            @Override
            public void run() {
                for(int i=0;i<100;i++){
                    print(i);
                }
            }
        };

        t1.start();

        for(int i=1; i<=10;i++){
            print(i);
        }
    }
}
