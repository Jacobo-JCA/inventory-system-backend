package com.softwarelabs.InventorySystem.modules.billing.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
