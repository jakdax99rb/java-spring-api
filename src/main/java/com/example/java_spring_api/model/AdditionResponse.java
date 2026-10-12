package com.example.java_spring_api.model;

import lombok.Data;

@Data
public class AdditionResponse {
    private int c;

    public AdditionResponse(AdditionRequest request) {
        this.c = request.getA() + request.getB();
    }
}
