package com.example.java_spring_api.controller;

import com.example.java_spring_api.exception.custom.CustomException;
import com.example.java_spring_api.model.HelloBody;
import com.example.java_spring_api.model.HelloWorldResponse;
import com.example.java_spring_api.service.ExampleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/insecure")
@RequiredArgsConstructor
@Slf4j
public class BaseController {

    private final ExampleService exampleService;

    @GetMapping(path = "/helloWorld", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public HelloWorldResponse helloWorld() {
        log.info("helloWorld");
        return new HelloWorldResponse();
    }

    @PostMapping(path = "/helloBody", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public HelloWorldResponse helloWorld(@RequestBody HelloBody body) {
        log.debug("A debug message!");
        log.info("A info message!");
        return new HelloWorldResponse(body.getMessage());
    }

    @GetMapping(path = "/customException", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public String customException() throws CustomException {
        log.error("Oh no, going to throw a custom error now!");
        throw new CustomException();
    }

    @GetMapping(path = "/envVar", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public String envVar() {
        log.info("Getting env variable!");
        return exampleService.getEnvVar();
    }
}
