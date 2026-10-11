package com.example.java_spring_api.exception;

import com.example.java_spring_api.exception.custom.AuthException;
import com.example.java_spring_api.exception.custom.CustomException;
import com.example.java_spring_api.exception.response.AuthExceptionResponse;
import com.example.java_spring_api.exception.response.CustomExceptionResponse;
import com.example.java_spring_api.exception.response.GenericExceptionResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public GenericExceptionResponse handleGenericException(Exception e) {
        log.error(e.getMessage(), e);
        return new GenericExceptionResponse();
    }

    @ExceptionHandler(CustomException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public CustomExceptionResponse handleCustomException(CustomException e) {
        log.error(e.getMessage(), e);
        return new CustomExceptionResponse();
    }

    @ExceptionHandler(AuthException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public AuthExceptionResponse handleAuthException(AuthException e) {
        log.error(e.getMessage());
        return new AuthExceptionResponse();
    }

}
