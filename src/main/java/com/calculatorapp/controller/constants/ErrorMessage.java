package com.calculatorapp.controller.constants;

public enum ErrorMessage {
    NAN("Not a Message");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
