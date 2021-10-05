package com.target.training.assignment17;

public class InvalidDateException extends RuntimeException {
    public InvalidDateException() {
    }

    public InvalidDateException(String message) {
        super(message);
    }

    public InvalidDateException(Throwable cause) {
        super(cause);
    }
}
