package com.softwarelabs.InventorySystem.modules.catalog.common.mapper;


import com.softwarelabs.InventorySystem.modules.catalog.dto.ProductRequestDTO;
import com.softwarelabs.InventorySystem.modules.catalog.dto.ProductResponse;
import com.softwarelabs.InventorySystem.modules.catalog.entity.Product;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;

public class ProductMapper {
    @Qualifier("productMapper")
    private static final ModelMapper mapper = new ModelMapper();

    public static ProductResponse convertToDto(Product obj) {
        return mapper.map(obj, ProductResponse.class);
    }

    public static Product convertToEntity(ProductRequestDTO dto) {
        return mapper.map(dto, Product.class);
    }
}
