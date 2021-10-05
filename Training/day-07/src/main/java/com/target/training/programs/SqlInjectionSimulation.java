package com.target.training.programs;


import com.target.training.utils.KeyboardUtil;

public class SqlInjectionSimulation {
    public static void main(String[] args) {

        String username;
        String password;

        username = KeyboardUtil.getString("Enter username: ");
        password = KeyboardUtil.getString("Enter password: ");

    }
}
