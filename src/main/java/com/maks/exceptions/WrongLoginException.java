package com.maks.exceptions;

public class WrongLoginException extends Exception {
    public WrongLoginException() {
    }

    public WrongLoginException(final String message) {
        super(message);
    }
}
