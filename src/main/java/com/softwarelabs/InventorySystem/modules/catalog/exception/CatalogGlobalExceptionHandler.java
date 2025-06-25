package com.softwarelabs.InventorySystem.modules.catalog.exception;


import com.softwarelabs.InventorySystem.modules.billing.exception.CustomerErrorResponse;
import com.softwarelabs.InventorySystem.modules.billing.exception.InvalidCredentialException;
import com.softwarelabs.InventorySystem.modules.billing.exception.NameValueRequiredException;
import com.softwarelabs.InventorySystem.modules.billing.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class CatalogGlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<com.softwarelabs.InventorySystem.modules.billing.exception.CustomerErrorResponse> handleAllExceptions(Exception ex, WebRequest req) {
        com.softwarelabs.InventorySystem.modules.billing.exception.CustomerErrorResponse response = com.softwarelabs.InventorySystem.modules.billing.exception.CustomerErrorResponse.builder()
                .datetime(LocalDateTime.now())
                .message(ex.getMessage())
                .path(req.getDescription(false))
                .build();
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(com.softwarelabs.InventorySystem.modules.billing.exception.NotFoundException.class)
    public ResponseEntity<com.softwarelabs.InventorySystem.modules.billing.exception.CustomerErrorResponse> handleNotFoundExceptions(NotFoundException ex, WebRequest req) {
        com.softwarelabs.InventorySystem.modules.billing.exception.CustomerErrorResponse response = com.softwarelabs.InventorySystem.modules.billing.exception.CustomerErrorResponse.builder()
                .datetime(LocalDateTime.now())
                .message(ex.getMessage())
                .path(req.getDescription(false))
                .build();
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(com.softwarelabs.InventorySystem.modules.billing.exception.NameValueRequiredException.class)
    public ResponseEntity<com.softwarelabs.InventorySystem.modules.billing.exception.CustomerErrorResponse> handleNameValueRequiredExceptions(NameValueRequiredException ex, WebRequest req) {
        com.softwarelabs.InventorySystem.modules.billing.exception.CustomerErrorResponse response = com.softwarelabs.InventorySystem.modules.billing.exception.CustomerErrorResponse.builder()
                .datetime(LocalDateTime.now())
                .message(ex.getMessage())
                .path(req.getDescription(false))
                .build();
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(com.softwarelabs.InventorySystem.modules.billing.exception.InvalidCredentialException.class)
    public ResponseEntity<com.softwarelabs.InventorySystem.modules.billing.exception.CustomerErrorResponse> handleInvalidCredentialExceptions(InvalidCredentialException ex, WebRequest req) {
        com.softwarelabs.InventorySystem.modules.billing.exception.CustomerErrorResponse response = CustomerErrorResponse.builder()
                .datetime(LocalDateTime.now())
                .message(ex.getMessage())
                .path(req.getDescription(false))
                .build();
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}