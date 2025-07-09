package com.softwarelabs.InventorySystem.modules.catalog.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Builder
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategory;
    @NotBlank(message = "Name is required")
    @Column(name = "name", unique = true)
    private String name;
    @ToString.Exclude
    @Column(name = "products")
    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
