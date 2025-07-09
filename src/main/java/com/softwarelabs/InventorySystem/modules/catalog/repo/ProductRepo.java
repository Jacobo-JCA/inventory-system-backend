package com.softwarelabs.InventorySystem.modules.catalog.repo;

import com.softwarelabs.InventorySystem.modules.catalog.entity.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends GenericRepo<Product, Long> {
}
