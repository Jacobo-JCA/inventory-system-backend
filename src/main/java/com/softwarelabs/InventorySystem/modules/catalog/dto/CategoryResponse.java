package com.softwarelabs.InventorySystem.modules.catalog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoryResponse {
    private Long idCategory;
    private String name;
}
