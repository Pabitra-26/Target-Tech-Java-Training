package com.target.training.model;

public class EmptyOrNullNameException extends RuntimeException {

    public EmptyOrNullNameException() {
    }

    public EmptyOrNullNameException(String message) {
        super(message);
    }

    public EmptyOrNullNameException(Throwable cause) {
        super(cause);
    }
}
