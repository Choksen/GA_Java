package com.maks.exceptions;

public class WrongPasswordException extends Exception {
    public WrongPasswordException() {
    }

    public WrongPasswordException(final String message) {
        super(message);
    }
}

