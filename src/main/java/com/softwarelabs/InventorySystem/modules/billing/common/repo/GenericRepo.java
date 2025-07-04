package com.softwarelabs.InventorySystem.modules.billing.common.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GenericRepo<T, ID> extends JpaRepository<T, ID> {
}
