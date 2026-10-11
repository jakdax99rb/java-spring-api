package com.example.java_spring_api.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.servlet.filter.OrderedFilter;
import org.springframework.boot.web.servlet.FilterRegistration;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

@Slf4j
@Component
@FilterRegistration(name = "LoggingFilter", urlPatterns = "/api/*", order =
        OrderedFilter.REQUEST_WRAPPER_FILTER_MAX_ORDER + 4)
public class LoggingFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        long startTime = System.currentTimeMillis();
        try {
            logIncomingRequest(request);
            filterChain.doFilter(request, response);
        } finally {
            long duration = System.currentTimeMillis() - startTime;
            logOutgoingResponse(request, response, duration);
        }
    }

    private void logIncomingRequest(HttpServletRequest request) {
        log.info("Incoming Request: method={}, uri={}, queryParams={}, ip={}", request.getMethod(), request.getRequestURI(), request.getQueryString(), request.getRemoteAddr());
    }

    private void logOutgoingResponse(HttpServletRequest request, HttpServletResponse response, long duration) {
        log.info("Outgoing Response: method={}, uri={}, status={}, duration={}ms. request body={} response body={}", request.getMethod(), request.getRequestURI(), response.getStatus(), duration, getRequestBody((ContentCachingRequestWrapper) request), getResponseBody((ContentCachingResponseWrapper) response));
    }


    private String getResponseBody(ContentCachingResponseWrapper response) {
        byte[] buf = response.getContentAsByteArray();
        try {
            return new String(buf, response.getCharacterEncoding());
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    private String getRequestBody(ContentCachingRequestWrapper request) {
        byte[] buf = request.getContentAsByteArray();
        try {
            return new String(buf, request.getCharacterEncoding());
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}