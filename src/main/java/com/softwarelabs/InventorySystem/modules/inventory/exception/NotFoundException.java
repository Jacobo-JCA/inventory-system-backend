package com.softwarelabs.InventorySystem.modules.inventory.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
