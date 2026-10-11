package com.example.java_spring_api.controller;

import com.example.java_spring_api.exception.custom.CustomException;
import com.example.java_spring_api.model.HelloBody;
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

    @GetMapping("/helloWorld")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public String helloWorld() {
        log.info("helloWorld");
        return "Hello World";
    }

    @PostMapping("/helloBody")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public String helloWorld(@RequestBody HelloBody body) {
        log.debug("A debug message!");
        log.info("A info message!");
        return "Hello " + body.getMessage();
    }

    @GetMapping("/customException")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public String customException() throws CustomException {
        log.error("Oh no, going to throw a custom error now!");
        throw new CustomException();
    }

    @GetMapping("/envVar")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public String envVar() {
        log.info("Getting env variable!");
        return exampleService.getEnvVar();
    }
}
