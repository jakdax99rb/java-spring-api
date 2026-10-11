package com.example.java_spring_api.controller;

import com.example.java_spring_api.model.HelloBody;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/insecure")
@RequiredArgsConstructor
@Slf4j
public class BaseController {
    @GetMapping("/helloWorld")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping("/helloBody")
    public String helloWorld(@RequestBody HelloBody body) {
        return "Hello " + body.getMessage();
    }
}
