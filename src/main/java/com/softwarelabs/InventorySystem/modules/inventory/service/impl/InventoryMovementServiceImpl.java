package com.softwarelabs.InventorySystem.modules.inventory.service.impl;

import com.softwarelabs.InventorySystem.modules.inventory.common.crud.CRUDImpl;
import com.softwarelabs.InventorySystem.modules.inventory.entity.InventoryMovement;
import com.softwarelabs.InventorySystem.modules.inventory.entity.MovementType;
import com.softwarelabs.InventorySystem.modules.inventory.entity.StockItem;
import com.softwarelabs.InventorySystem.modules.inventory.repo.GenericInventoryRepo;
import com.softwarelabs.InventorySystem.modules.inventory.repo.InventoryMovementRepo;
import com.softwarelabs.InventorySystem.modules.inventory.service.InventoryMovementService;
import com.softwarelabs.InventorySystem.modules.inventory.service.StockItemService;
import com.softwarelabs.InventorySystem.modules.user.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@RequiredArgsConstructor
@Service
public class InventoryMovementServiceImpl extends CRUDImpl<InventoryMovement, Long> implements InventoryMovementService {
    private final InventoryMovementRepo inventoryMovementRepo;
    private final StockItemService stockItemService;

    @Override
    protected GenericInventoryRepo<InventoryMovement, Long> getRepo() {
        return inventoryMovementRepo;
    }

    @Override
    public InventoryMovement update(InventoryMovement inventoryMovement, Long aLong) throws Exception {
        inventoryMovement.setIdInventory(aLong);
        MovementType type = inventoryMovement.getType();
        StockItem stockItem = inventoryMovement.getStockItem();
        short quantity = inventoryMovement.getQuantity();
        if(!(type == MovementType.RETURN)) {
            throw new NotFoundException("Type Not Found");
        }
        Objects.requireNonNull(type);
        short newQuantity = (short)(stockItem.getQuantity() + quantity);
        if (newQuantity < 0) {
            throw new NotFoundException("Insufficient stock");
        }
        stockItem.setQuantity(newQuantity);
        stockItemService.save(stockItem);
        return super.update(inventoryMovement, aLong);
    }
}
