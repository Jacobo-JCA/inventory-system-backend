package com.softwarelabs.InventorySystem.modules.catalog.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategory;
    @NotBlank(message = "Name is required")
    @Column(unique = true)
    private String name;
    @OneToMany(mappedBy = "category")
    private List<Product> products;

    @Override
    public String toString() {
        return "Category{" +
                "idCategory=" + idCategory +
                ", name='" + name + '\'' +
                '}';
    }
}
