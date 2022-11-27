package com.cursproject.Exceptions;

public class PasswordCheckFailureException extends Exception {
    public PasswordCheckFailureException(String message) {
        super(message);
    }
}