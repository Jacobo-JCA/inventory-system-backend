package com.softwarelabs.InventorySystem.modules.inventory.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Builder
@Entity
@Table(name = "inventory_movements")
public class InventoryMovement {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInventory;
    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private MovementType type;
    @Column(name = "quantity")
    private short quantity;
    @Column(name = "price", precision = 12, scale = 2, nullable = false)
    private BigDecimal totalPrice;
    @Column(name = "movement_date", nullable = false)
    private LocalDateTime movementDate;
    @Size(max = 50)
    @Column(name = "reference_number", nullable = false)
    private String referenceNumber;
    @Size(max = 80, message = "The reason cannot exceed 80 characters")
    private String reason;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_stock", nullable = false)
    private StockItem stockItem;

    @PrePersist
    private void prePersist() {
        if (movementDate == null) {
            movementDate = LocalDateTime.now();
        }
    }

    @PreUpdate
    private void preUpdate() {
        movementDate = LocalDateTime.now();
    }
}
