package com.example.java_spring_api.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.servlet.filter.OrderedFilter;
import org.springframework.boot.web.servlet.FilterRegistration;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;


@Slf4j
@Component
@FilterRegistration(name = "ExceptionHandlerFilter", urlPatterns = "/api/*", order =
        OrderedFilter.REQUEST_WRAPPER_FILTER_MAX_ORDER + 1)
public class ExceptionHandlerFilter extends OncePerRequestFilter {

    private final HandlerExceptionResolver handlerExceptionResolver;

    public ExceptionHandlerFilter(@Qualifier("handlerExceptionResolver") HandlerExceptionResolver handlerExceptionResolver) {
        this.handlerExceptionResolver = handlerExceptionResolver;
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) {
        try {
            filterChain.doFilter(request, response);
        } catch (Exception e) {
            log.error("Exception occurred while processing request, passing to resolver");
            handlerExceptionResolver.resolveException(request, response, null, e);
        }
    }
}
