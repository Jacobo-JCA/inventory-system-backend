package com.softwarelabs.InventorySystem.modules.catalog.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductRequestDTO {
    private Long idProduct;
    @NotNull(message = "La categoría es obligatoria")
    private Long idCategory;
    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 100)
    private String name;
    @Pattern(regexp = "^[A-Z0-9-]{5,20}$")
    private String code;
    @DecimalMin(value = "0.0", inclusive = false)
    private BigDecimal price;
    @Min(0)
    private Integer stockQuantity;
    @Size(max = 500)
    private String description;
}
