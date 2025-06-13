package com.softwarelabs.InventorySystem.modules.security.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerErrorResponse {
    private LocalDateTime dateTime;
    private String message;
    private String path;
}
