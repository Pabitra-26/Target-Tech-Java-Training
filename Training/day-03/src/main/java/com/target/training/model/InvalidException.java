package com.target.training.model;

public class InvalidException extends RuntimeException {

    public InvalidException() {
    }

    public InvalidException(String message) {
        super(message);
    }

    public InvalidException(Throwable cause) {
        super(cause);
    }
}
