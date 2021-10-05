package com.target.training.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomerNoFoundException extends RuntimeException {

    public CustomerNoFoundException() {
    }

    public CustomerNoFoundException(String message) {
        super(message);
    }

    public CustomerNoFoundException(Throwable cause) {
        super(cause);
    }
}
