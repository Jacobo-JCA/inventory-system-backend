package com.softwarelabs.InventorySystem.modules.inventory.dto;

import com.softwarelabs.InventorySystem.modules.inventory.entity.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StockItemResponse {
    private Long idStock;
    private Long idProduct;
    private short quantity;
    private String location;
    private LocalDateTime lastUpdate;
    private Status status;
}
