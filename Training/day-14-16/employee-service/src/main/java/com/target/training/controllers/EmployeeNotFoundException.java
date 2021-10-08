package com.target.training.controllers;

public class EmployeeNotFoundException extends RuntimeException {

    public EmployeeNotFoundException() {
    }

    public EmployeeNotFoundException(String message) {
        super(message);
    }

    public EmployeeNotFoundException(Throwable cause) {
        super(cause);
    }
}
