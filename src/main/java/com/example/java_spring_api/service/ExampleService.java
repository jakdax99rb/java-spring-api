package com.example.java_spring_api.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Getter
@Service
@RequiredArgsConstructor
public class ExampleService {
    @Value("${some.env.specific.var:NO VALUE}")
    private String envVar;
}
