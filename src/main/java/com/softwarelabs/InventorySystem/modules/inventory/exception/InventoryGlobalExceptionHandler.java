package com.softwarelabs.InventorySystem.modules.inventory.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class InventoryGlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<CustomerErrorResponse> handleAllExceptions(Exception ex, WebRequest req) {
        CustomerErrorResponse response = CustomerErrorResponse.builder()
                .datetime(LocalDateTime.now())
                .message(ex.getMessage())
                .path(req.getDescription(false))
                .build();
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<CustomerErrorResponse> handleNotFoundExceptions(NotFoundException ex, WebRequest req) {
        CustomerErrorResponse response = CustomerErrorResponse.builder()
                .datetime(LocalDateTime.now())
                .message(ex.getMessage())
                .path(req.getDescription(false))
                .build();
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}