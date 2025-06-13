package com.softwarelabs.InventorySystem.modules.catalog.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductResponseDTO {
    private Long idProduct;
    private Long idCategory;
    private String name;
    private String code;
    private BigDecimal price;
    private Integer stockQuantity;
    private String description;
    private LocalDateTime createdAt;
}
