package com.softwarelabs.InventorySystem.modules.inventory.dto;

import com.softwarelabs.InventorySystem.modules.inventory.entity.MovementType;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class InventoryMovementRequestDTO {
    @NotNull(message = "The type of movement is obligatory")
    private MovementType type;
    @NotNull(message = "The amount is obligatory")
    @Min(value = 1, message = "The quantity must be at least 1")
    private Short quantity;
    @NotNull(message = "The total price is obligatory")
    @DecimalMin(value = "0.01", message = "The price must be greater than 0")
    private BigDecimal totalPrice;
    @NotBlank(message = "The reference number is required")
    private String referenceNumber;
    @Size(max = 80, message = "The reason may not exceed 80 characters")
    private String reason;
    @NotNull(message = "Stock ID is required")
    @Positive(message = "The stock ID must be a positive value")
    private Long idStock;
}