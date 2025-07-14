package com.softwarelabs.InventorySystem.modules.inventory.common.mapper;


import com.softwarelabs.InventorySystem.modules.inventory.dto.InventoryMovementRequestDTO;
import com.softwarelabs.InventorySystem.modules.inventory.dto.InventoryMovementResponse;
import com.softwarelabs.InventorySystem.modules.inventory.entity.InventoryMovement;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;

public class InventoryMovementMapper {
    @Qualifier("inventoryMapper")
    private static final ModelMapper mapper = new ModelMapper();

    public static InventoryMovementResponse convertToDto(InventoryMovement obj) {
        return mapper.map(obj, InventoryMovementResponse.class);
    }

    public static InventoryMovement convertToEntity(InventoryMovementRequestDTO dto) {
        return mapper.map(dto, InventoryMovement.class);
    }
}
