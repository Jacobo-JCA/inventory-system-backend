package com.softwarelabs.InventorySystem.modules.inventory.service;

import com.softwarelabs.InventorySystem.modules.inventory.common.crud.CRUD;
import com.softwarelabs.InventorySystem.modules.inventory.entity.StockItem;

public interface StockItemService extends CRUD<StockItem, Long> {
    StockItem transferStock(Long idStockItem, String location) throws Exception;
}
