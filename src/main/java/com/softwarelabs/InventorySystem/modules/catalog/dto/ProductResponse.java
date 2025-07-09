package com.softwarelabs.InventorySystem.modules.catalog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductResponse {
    private Long idProduct;
    private Long idCategory;
    private String name;
    private String code;
    private BigDecimal unitPrice;
    private Integer stockQuantity;
    private String description;
    private LocalDateTime createdAt;
}
