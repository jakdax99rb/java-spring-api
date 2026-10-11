package com.example.java_spring_api.exception.response;

import lombok.Data;

@Data
public class GenericExceptionResponse {
    private String message;

    public GenericExceptionResponse() {
        this.message = "Generic exception encountered";
    }
}
