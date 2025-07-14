package com.softwarelabs.InventorySystem.modules.catalog.common.mapper;

import com.softwarelabs.InventorySystem.modules.catalog.dto.CategoryRequestDTO;
import com.softwarelabs.InventorySystem.modules.catalog.dto.CategoryResponse;
import com.softwarelabs.InventorySystem.modules.catalog.dto.ProductRequestDTO;
import com.softwarelabs.InventorySystem.modules.catalog.dto.ProductResponse;
import com.softwarelabs.InventorySystem.modules.catalog.entity.Category;
import com.softwarelabs.InventorySystem.modules.catalog.entity.Product;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperCatalogConfig {
    @Bean("categoryMapper")
    public ModelMapper categoryMapper() {
        ModelMapper mapper = new ModelMapper();
        TypeMap<CategoryRequestDTO, Category> type1 = mapper.createTypeMap(CategoryRequestDTO.class, Category.class);
        TypeMap<Category, CategoryResponse> type2 = mapper.createTypeMap(Category.class, CategoryResponse.class);
        return mapper;
    }

    @Bean("productMapper")
    public ModelMapper productMapper() {
        ModelMapper mapper = new ModelMapper();
        TypeMap<ProductRequestDTO, Product> type1 = mapper.createTypeMap(ProductRequestDTO.class, Product.class);
        TypeMap<Product, ProductResponse> type2 = mapper.createTypeMap(Product.class, ProductResponse.class);
        return mapper;
    }
}
