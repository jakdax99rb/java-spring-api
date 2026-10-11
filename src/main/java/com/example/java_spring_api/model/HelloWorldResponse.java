package com.example.java_spring_api.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class HelloWorldResponse {
    private String message;
    private LocalDateTime timestamp;

    public HelloWorldResponse() {
        this.timestamp = LocalDateTime.now();
        this.message = "Hello World!";
    }

    public HelloWorldResponse(String message) {
        this.timestamp = LocalDateTime.now();
        this.message = "Hello " + message + "!";
    }
}
