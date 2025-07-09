package com.softwarelabs.InventorySystem.modules.catalog.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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
    @NotBlank(message = "Name is required")
    private String name;
    @NotBlank(message = "Code is required")
    private String code;
    @Min(value = 1)
    @Max(value = 9999)
    @Positive(message = "Product price must be a positive value")
    private BigDecimal unitPrice;
    @Min(value = 0, message = "Stock quantity cannot be lesser than zero")
    private Integer stockQuantity;
    private String description;
    private final LocalDateTime createdAt = LocalDateTime.now();
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "id_category", nullable = false)
    private Category category;
}