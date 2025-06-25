package com.softwarelabs.InventorySystem.modules.user.repo;

import com.softwarelabs.InventorySystem.modules.user.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepo extends JpaRepository<UserRole, Long> {
}
