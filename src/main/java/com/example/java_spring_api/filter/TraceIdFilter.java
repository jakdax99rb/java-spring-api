package com.example.java_spring_api.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.boot.servlet.filter.OrderedFilter;
import org.springframework.boot.web.servlet.FilterRegistration;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.UUID;

@Slf4j
@Component
@FilterRegistration(name = "TraceIdFilter", urlPatterns = "/api/*", order =
        OrderedFilter.REQUEST_WRAPPER_FILTER_MAX_ORDER + 2)
public class TraceIdFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String traceIdHeader = "traceId";
        String traceId = request.getHeader(traceIdHeader);
        if (traceId == null) {
            traceId = UUID.randomUUID().toString();
        }
        MDC.put(traceIdHeader, traceId);
        filterChain.doFilter(request, response);
    }
}
