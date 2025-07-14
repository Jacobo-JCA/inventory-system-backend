package com.softwarelabs.InventorySystem.modules.inventory.repo;

import com.softwarelabs.InventorySystem.modules.inventory.entity.StockItem;
import org.springframework.stereotype.Repository;

@Repository
public interface StockItemRepo extends GenericInventoryRepo<StockItem, Long> {
}
