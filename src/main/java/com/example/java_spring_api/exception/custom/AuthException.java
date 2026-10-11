package com.example.java_spring_api.exception.custom;

import lombok.experimental.StandardException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "Not Authorized")
@StandardException
public class AuthException extends RuntimeException {}
