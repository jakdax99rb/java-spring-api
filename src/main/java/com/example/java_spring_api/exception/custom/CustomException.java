package com.example.java_spring_api.exception.custom;

import lombok.experimental.StandardException;

@StandardException
public class CustomException extends Exception {
    public CustomException() {
        super("Some custom error has occurred!");
    }
}
