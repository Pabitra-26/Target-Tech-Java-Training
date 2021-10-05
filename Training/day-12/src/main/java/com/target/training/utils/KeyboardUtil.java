package com.target.training.utils;

import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

@Slf4j
public class KeyboardUtil {

    public static String getString(String message){
        log.debug(message);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static Integer getInt(String message){
        log.debug(message);
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public static Double getDouble(String message){
        log.debug(message);
        Scanner sc = new Scanner(System.in);
        return sc.nextDouble();
    }
}
