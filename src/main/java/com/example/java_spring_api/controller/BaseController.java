package com.example.java_spring_api.controller;

import com.example.java_spring_api.model.HelloBody;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/insecure")
@RequiredArgsConstructor
@Slf4j
public class BaseController {
    @GetMapping("/helloWorld")
    @ResponseBody
    public String helloWorld() {
        log.info("helloWorld");
        return "Hello World";
    }

    @GetMapping("/helloBody")
    @ResponseBody
    public String helloWorld(@RequestBody HelloBody body) {
        log.debug("A debug message!");
        log.info("A info message!");
        return "Hello " + body.getMessage();
    }
}
