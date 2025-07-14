package com.softwarelabs.InventorySystem.modules.catalog.entity;

import com.softwarelabs.InventorySystem.modules.inventory.entity.StockItem;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Builder
@Entity
@Table(name = "products")
public class Product {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduct;
    @Column(name = "name")
    private String name;
    @Column(name = "code")
    private String code;
    @Column(name = "unit_price", precision = 12, scale = 2, nullable = false)
    private BigDecimal unitPrice;
    @Column(name = "description")
    private String description;
    private final LocalDateTime createdAt = LocalDateTime.now();
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "id_category", nullable = false)
    private Category category;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StockItem> stockItems;
}