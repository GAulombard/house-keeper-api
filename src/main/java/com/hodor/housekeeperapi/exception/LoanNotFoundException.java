package com.hodor.housekeeperapi.exception;

public class LoanNotFoundException extends Exception {

    public LoanNotFoundException(String message) {
        super(message);
    }
}