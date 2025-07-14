package com.softwarelabs.InventorySystem.modules.catalog.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductRequestDTO {
    @NotNull(message = "Category is required")
    private Long idCategory;
    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 50)
    private String name;
    @NotBlank(message = "Code is required")
    @Pattern(regexp = "^[A-Z0-9-]{5,20}$")
    private String code;
    @Min(value = 1)
    @Max(value = 9999)
    @Positive(message = "Product price must be a positive value")
    @DecimalMin(value = "0.0", inclusive = false)
    private BigDecimal unitPrice;
    @Size(min = 3, max = 100)
    private String description;
}
