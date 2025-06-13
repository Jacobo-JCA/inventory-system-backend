package com.softwarelabs.InventorySystem.modules.catalog.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class Product {
    @Id
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
    @ManyToOne
    @JoinColumn(name = "id_category", nullable = false)
    private Category category;

    @Override
    public String toString() {
        return "Product{" +
                "idProduct=" + idProduct +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", stockQuantity=" + stockQuantity +
                ", description='" + description + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}