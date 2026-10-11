package com.example.java_spring_api.filter;
import com.example.java_spring_api.exception.custom.AuthException;
import com.example.java_spring_api.security.AuthHelper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.servlet.filter.OrderedFilter;
import org.springframework.boot.web.servlet.FilterRegistration;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Slf4j
@Component
@FilterRegistration(name = "AuthenticationFilter", urlPatterns = "/api/secure/*", order =
        OrderedFilter.REQUEST_WRAPPER_FILTER_MAX_ORDER + 2)
public class AuthFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        if (AuthHelper.isAuthed(request.getHeader(HttpHeaders.AUTHORIZATION))) {
            log.info("Authentication successful");
            filterChain.doFilter(request, response);
        } else {
            log.info("Authentication unsuccessful");
            throw new AuthException("Authentication unsuccessful");
        }
    }
}
