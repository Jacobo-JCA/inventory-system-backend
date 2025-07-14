package com.softwarelabs.InventorySystem.modules.inventory.dto;

import com.softwarelabs.InventorySystem.modules.inventory.entity.Status;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StockItemRequestDTO {
    @NotNull(message = "Product ID is mandatory")
    @Positive(message = "Product ID must be positive")
    private Long productId;
    @NotNull(message = "The amount cannot be zero")
    @PositiveOrZero(message = "The quantity must be a positive number or zero")
    private short quantity;
    @NotBlank(message = "The location cannot be empty")
    @Size(max = 80, message = "The location cannot exceed 80 characters")
    private String location;
    @NotNull(message = "The state cannot be null and void")
    private Status status;
}