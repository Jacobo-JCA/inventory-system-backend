package com.softwarelabs.InventorySystem.modules.catalog.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GenericCatalogRepo<T, ID> extends JpaRepository<T, ID> {
}
