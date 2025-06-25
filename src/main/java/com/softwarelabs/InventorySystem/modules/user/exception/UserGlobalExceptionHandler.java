package com.softwarelabs.InventorySystem.modules.user.exception;


import com.softwarelabs.InventorySystem.modules.billing.exception.CustomerErrorResponse;
import com.softwarelabs.InventorySystem.modules.billing.exception.InvalidCredentialException;
import com.softwarelabs.InventorySystem.modules.billing.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class UserGlobalExceptionHandler {
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

    @ExceptionHandler(InvalidCredentialException.class)
    public ResponseEntity<CustomerErrorResponse> handleInvalidCredentialExceptions(InvalidCredentialException ex, WebRequest req) {
        CustomerErrorResponse response = CustomerErrorResponse.builder()
                .datetime(LocalDateTime.now())
                .message(ex.getMessage())
                .path(req.getDescription(false))
                .build();
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}