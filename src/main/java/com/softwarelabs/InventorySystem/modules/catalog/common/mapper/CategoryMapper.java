package com.softwarelabs.InventorySystem.modules.catalog.common.mapper;


import com.softwarelabs.InventorySystem.modules.catalog.dto.CategoryRequestDTO;
import com.softwarelabs.InventorySystem.modules.catalog.dto.CategoryResponse;
import com.softwarelabs.InventorySystem.modules.catalog.entity.Category;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;

public class CategoryMapper {
    @Qualifier("categoryMapper")
    private static final ModelMapper mapper = new ModelMapper();

    public static CategoryResponse convertToDto(Category obj) {
        return mapper.map(obj, CategoryResponse.class);
    }

    public static Category convertToEntity(CategoryRequestDTO dto) {
        return mapper.map(dto, Category.class);
    }
}
