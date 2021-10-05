package com.target.training.assignment17;

public class InvalidInputException extends RuntimeException {
    public InvalidInputException() {
    }

    public InvalidInputException(String message) {
        super(message);
    }

    public InvalidInputException(Throwable cause) {
        super(cause);
    }
}
