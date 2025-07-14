package com.softwarelabs.InventorySystem.modules.inventory.common.mapper;

import com.softwarelabs.InventorySystem.modules.catalog.dto.CategoryRequestDTO;
import com.softwarelabs.InventorySystem.modules.catalog.dto.CategoryResponse;
import com.softwarelabs.InventorySystem.modules.catalog.dto.ProductRequestDTO;
import com.softwarelabs.InventorySystem.modules.catalog.dto.ProductResponse;
import com.softwarelabs.InventorySystem.modules.catalog.entity.Category;
import com.softwarelabs.InventorySystem.modules.catalog.entity.Product;
import com.softwarelabs.InventorySystem.modules.inventory.dto.StockItemRequestDTO;
import com.softwarelabs.InventorySystem.modules.inventory.dto.StockItemResponse;
import com.softwarelabs.InventorySystem.modules.inventory.entity.StockItem;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    @Bean("inventoryMapper")
    public ModelMapper inventoryMapper() {
        ModelMapper mapper = new ModelMapper();
        TypeMap<CategoryRequestDTO, Category> type1 = mapper.createTypeMap(CategoryRequestDTO.class, Category.class);
        TypeMap<Category, CategoryResponse> type2 = mapper.createTypeMap(Category.class, CategoryResponse.class);
        return mapper;
    }

    @Bean("stockMapper")
    public ModelMapper stockMapper() {
        ModelMapper mapper = new ModelMapper();
        TypeMap<StockItemRequestDTO, StockItem> type1 = mapper.createTypeMap(StockItemRequestDTO.class, StockItem.class);
        TypeMap<StockItem, StockItemResponse> type2 = mapper.createTypeMap(StockItem.class, StockItemResponse.class);
        return mapper;
    }
}
