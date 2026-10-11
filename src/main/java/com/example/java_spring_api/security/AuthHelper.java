package com.example.java_spring_api.security;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AuthHelper {

    public static boolean isAuthed(String authHeader) {
        return authHeader != null && authHeader.equals("authenticated");
    }


}
