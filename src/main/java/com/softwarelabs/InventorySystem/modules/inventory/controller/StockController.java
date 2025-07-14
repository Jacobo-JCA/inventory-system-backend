package com.softwarelabs.InventorySystem.modules.inventory.controller;

import com.softwarelabs.InventorySystem.modules.inventory.common.mapper.StockItemMapper;
import com.softwarelabs.InventorySystem.modules.inventory.dto.StockItemRequestDTO;
import com.softwarelabs.InventorySystem.modules.inventory.dto.StockItemResponse;
import com.softwarelabs.InventorySystem.modules.inventory.entity.StockItem;
import com.softwarelabs.InventorySystem.modules.inventory.service.StockItemService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/stocks")
@RestController
public class StockController {
    private final StockItemService stockItemService;

    @PostMapping("/add")
    public ResponseEntity<StockItemResponse> createCategory(@RequestBody @Valid StockItemRequestDTO stockItemRequestDTO) throws Exception {
        StockItem stockItem = stockItemService.save(StockItemMapper.convertToEntity(stockItemRequestDTO));
        return new ResponseEntity<>(StockItemMapper.convertToDto(stockItem), HttpStatus.CREATED);
    }
}
