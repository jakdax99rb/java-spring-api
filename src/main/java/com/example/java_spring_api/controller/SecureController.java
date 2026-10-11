package com.example.java_spring_api.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/secure")
@RequiredArgsConstructor
@Slf4j
public class SecureController {
    @GetMapping("/helloWorld")
    public String helloWorld() {
        log.info("hello Secure World");
        return "Hello Secure World";
    }
}
