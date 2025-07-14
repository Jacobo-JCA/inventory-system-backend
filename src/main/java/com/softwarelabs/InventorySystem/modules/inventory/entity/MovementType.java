package com.softwarelabs.InventorySystem.modules.inventory.entity;

public enum MovementType {
    PURCHASE,     // Compra a proveedor
    SALE,         // Venta a cliente
    ADJUSTMENT,    // Ajuste de inventario
    RETURN,        // Devolución de cliente
    TRANSFER;    // Transferencia entre almacenes
}
