package com.softwarelabs.InventorySystem.modules.inventory.entity;

import com.softwarelabs.InventorySystem.modules.catalog.entity.Product;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Builder
@Entity
@Table(name = "stock_items")
public class StockItem {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idStock;
    @Column(name = "quantity")
    private short quantity;
    @Column(name = "location", nullable = false)
    private String location;
    @Column(name = "last_update")
    private LocalDateTime lastUpdate;
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "id_product", nullable = false)
    private Product product;
    @ToString.Exclude
    @OneToMany(mappedBy = "stockItem")
    private List<InventoryMovement> movements;

    @PreUpdate
    @PrePersist
    public void validateStock() {
        if (quantity < 0) {
            throw new IllegalStateException("Stock cannot be negative");
        }
    }

    @PrePersist
    private void prePersist() {
        if (lastUpdate == null) {
            lastUpdate = LocalDateTime.now();
        }
    }

    @PreUpdate
    private void preUpdate() {
        lastUpdate = LocalDateTime.now();
    }
}
