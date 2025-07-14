package com.softwarelabs.InventorySystem.modules.inventory.common.mapper;

import com.softwarelabs.InventorySystem.modules.inventory.dto.InventoryMovementRequestDTO;
import com.softwarelabs.InventorySystem.modules.inventory.dto.InventoryMovementResponse;
import com.softwarelabs.InventorySystem.modules.inventory.dto.StockItemRequestDTO;
import com.softwarelabs.InventorySystem.modules.inventory.dto.StockItemResponse;
import com.softwarelabs.InventorySystem.modules.inventory.entity.InventoryMovement;
import com.softwarelabs.InventorySystem.modules.inventory.entity.StockItem;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperInventoryConfig {
    @Bean("inventoryMapper")
    public ModelMapper inventoryMapper() {
        ModelMapper mapper = new ModelMapper();
        TypeMap<InventoryMovementRequestDTO, InventoryMovement> type1 = mapper.createTypeMap(InventoryMovementRequestDTO.class,
                InventoryMovement.class);
        TypeMap<InventoryMovement, InventoryMovementResponse> type2 = mapper.createTypeMap(InventoryMovement.class,
                InventoryMovementResponse.class);
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
