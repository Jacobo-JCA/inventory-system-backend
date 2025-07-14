package com.softwarelabs.InventorySystem.modules.inventory.controller;

import com.softwarelabs.InventorySystem.modules.inventory.common.mapper.InventoryMovementMapper;
import com.softwarelabs.InventorySystem.modules.inventory.dto.InventoryMovementRequestDTO;
import com.softwarelabs.InventorySystem.modules.inventory.dto.InventoryMovementResponse;
import com.softwarelabs.InventorySystem.modules.inventory.entity.InventoryMovement;
import com.softwarelabs.InventorySystem.modules.inventory.service.InventoryMovementService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/inventories")
@RestController
public class InventoryController {
    private final InventoryMovementService inventoryMovementService;

    @PutMapping("/update/{id}")
    public ResponseEntity<InventoryMovementResponse> updateInventory(@PathVariable Long id, @RequestBody @Valid InventoryMovementRequestDTO movement) throws Exception {
        InventoryMovement inventoryMovement = inventoryMovementService.update(InventoryMovementMapper.convertToEntity(movement), id);
        return new ResponseEntity<>(InventoryMovementMapper.convertToDto(inventoryMovement), HttpStatus.ACCEPTED);
    }
}
