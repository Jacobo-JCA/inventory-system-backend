package com.softwarelabs.InventorySystem.modules.inventory.service.impl;

import com.softwarelabs.InventorySystem.modules.inventory.common.crud.CRUDImpl;
import com.softwarelabs.InventorySystem.modules.inventory.entity.InventoryMovement;
import com.softwarelabs.InventorySystem.modules.inventory.entity.StockItem;
import com.softwarelabs.InventorySystem.modules.inventory.repo.GenericInventoryRepo;
import com.softwarelabs.InventorySystem.modules.inventory.repo.InventoryMovementRepo;
import com.softwarelabs.InventorySystem.modules.inventory.service.InventoryMovementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class InventoryMovementServiceImpl extends CRUDImpl<InventoryMovement, Long> implements InventoryMovementService {
    private final InventoryMovementRepo inventoryMovementRepo;

    @Override
    protected GenericInventoryRepo<InventoryMovement, Long> getRepo() {
        return inventoryMovementRepo;
    }

    @Override
    public InventoryMovement update(InventoryMovement inventoryMovement, Long aLong) throws Exception {
        StockItem stockItem = inventoryMovement.getStockItem();

        return super.update(inventoryMovement, aLong);
    }
}
