package com.softwarelabs.InventorySystem.modules.security.core;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.softwarelabs.InventorySystem.modules.security.exception.CustomerErrorResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDateTime;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {
    private String convertObjectJson(Object object) throws JsonProcessingException {
        if(object == null) {
            return null;
        }
        ObjectMapper mapper = new ObjectMapper()
                .findAndRegisterModules();
        return mapper.writeValueAsString(object);
    }

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
            throws IOException, ServletException {
        String exceptionMsg = (String)request.getAttribute("exception");
        if(exceptionMsg == null) {
            exceptionMsg = "Token Not Found";
        }
        CustomerErrorResponse errorResponse =
                new CustomerErrorResponse(LocalDateTime.now(), exceptionMsg, request.getRequestURI());
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.getWriter().write(convertObjectJson(errorResponse));
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
    }
}
