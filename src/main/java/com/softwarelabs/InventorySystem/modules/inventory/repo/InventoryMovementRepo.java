package com.softwarelabs.InventorySystem.modules.inventory.repo;

import com.softwarelabs.InventorySystem.modules.inventory.entity.InventoryMovement;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryMovementRepo extends GenericInventoryRepo<InventoryMovement, Long> {
}
