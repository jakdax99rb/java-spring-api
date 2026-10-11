package com.example.java_spring_api.exception.response;

import lombok.Data;

@Data
public class CustomExceptionResponse {
    private String message;

    public CustomExceptionResponse() {
        this.message = "Custom Exception encountered";
    }
}
