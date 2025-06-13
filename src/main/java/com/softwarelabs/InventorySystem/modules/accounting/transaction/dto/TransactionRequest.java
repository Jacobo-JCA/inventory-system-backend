package com.softwarelabs.InventorySystem.modules.accounting.transaction.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionRequest {
    @Positive(message = "Product id is positive")
    private Long idProduct;
    @Positive(message = "Quantity id is positive")
    private Integer quantity;
    @Positive(message = "Supplier id is positive")
    private Long idSupplier;
    private String description;
}
