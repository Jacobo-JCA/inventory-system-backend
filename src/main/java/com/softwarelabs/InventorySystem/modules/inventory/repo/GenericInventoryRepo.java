package com.softwarelabs.InventorySystem.modules.inventory.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GenericInventoryRepo<T, ID> extends JpaRepository<T, ID> {
}
