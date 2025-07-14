package com.softwarelabs.InventorySystem.modules.inventory.common.mapper;

import com.softwarelabs.InventorySystem.modules.inventory.dto.StockItemRequestDTO;
import com.softwarelabs.InventorySystem.modules.inventory.dto.StockItemResponse;
import com.softwarelabs.InventorySystem.modules.inventory.entity.StockItem;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;

public class StockItemMapper {
    @Qualifier("stockMapper")
    private static final ModelMapper mapper = new ModelMapper();

    public static StockItemResponse convertToDto(StockItem obj) {
        return mapper.map(obj, StockItemResponse.class);
    }

    public static StockItem convertToEntity(StockItemRequestDTO dto) {
        return mapper.map(dto, StockItem.class);
    }
}
