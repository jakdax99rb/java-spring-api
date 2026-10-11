package com.example.java_spring_api.exception.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AuthExceptionResponse {
    private String message = "Unauthorized";
}
