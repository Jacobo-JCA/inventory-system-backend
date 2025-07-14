package com.softwarelabs.InventorySystem.modules.inventory.common.mapper;


import com.softwarelabs.InventorySystem.modules.catalog.dto.CategoryRequestDTO;
import com.softwarelabs.InventorySystem.modules.catalog.dto.CategoryResponse;
import com.softwarelabs.InventorySystem.modules.catalog.entity.Category;
import com.softwarelabs.InventorySystem.modules.inventory.entity.InventoryMovement;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;

public class InventoryMovementMapper {
    @Qualifier("inventoryMapper")
    private static final ModelMapper mapper = new ModelMapper();

    public static CategoryResponse convertToDto(Category obj) {
        return mapper.map(obj, CategoryResponse.class);
    }

    public static InventoryMovement convertToEntity(CategoryRequestDTO dto) {
        return mapper.map(dto, Category.class);
    }
}
