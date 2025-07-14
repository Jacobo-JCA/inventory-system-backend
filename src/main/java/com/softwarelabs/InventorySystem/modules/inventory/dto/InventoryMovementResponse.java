package com.softwarelabs.InventorySystem.modules.inventory.dto;

import com.softwarelabs.InventorySystem.modules.inventory.entity.MovementType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class InventoryMovementResponse {
    private Long idInventory;
    private MovementType type;
    private short quantity;
    private BigDecimal totalPrice;
    private LocalDateTime movementDate;
    private String referenceNumber;
    private String reason;
    private Long stockId;
}
