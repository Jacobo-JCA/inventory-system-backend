package com.softwarelabs.InventorySystem.modules.inventory.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CustomerErrorResponse {
    private LocalDateTime datetime;
    private String message;
    private String path;
}
