package com.softwarelabs.InventorySystem.modules.inventory.service.impl;

import com.softwarelabs.InventorySystem.modules.inventory.common.crud.CRUDImpl;
import com.softwarelabs.InventorySystem.modules.inventory.entity.StockItem;
import com.softwarelabs.InventorySystem.modules.inventory.repo.GenericInventoryRepo;
import com.softwarelabs.InventorySystem.modules.inventory.repo.StockItemRepo;
import com.softwarelabs.InventorySystem.modules.inventory.service.StockItemService;
import com.softwarelabs.InventorySystem.modules.user.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class StockItemServiceImpl extends CRUDImpl<StockItem, Long> implements StockItemService {
    private final StockItemRepo stockItemRepo;

    @Override
    protected GenericInventoryRepo<StockItem, Long> getRepo() {
        return stockItemRepo;
    }

    @Override
    public StockItem transferStock(Long idStockItem, String newLocation) throws Exception {
        StockItem item = stockItemRepo.findById(idStockItem).orElseThrow(() -> new NotFoundException("ID Not Found"));
        item.setLocation(newLocation);
        return stockItemRepo.save(item);
    }
}
