package com.target.training.programs;

import com.target.training.util.KeyboardUtil;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class AcceptFromKeyboard {

    public static void main(String[] args) {

        String name = KeyboardUtil.getString("Enter your name: ");
        Integer age = KeyboardUtil.getInt("Enter your age: ");
        String city = KeyboardUtil.getString("Enter your city: ");

        log.debug("{} from {} is {} years old.", name, city, age);

    }
}
