package com.softwarelabs.InventorySystem.modules.catalog.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoryDTO {
    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 50)
    private String name;
}
