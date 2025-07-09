package com.softwarelabs.InventorySystem.modules.user.repo;

import com.softwarelabs.InventorySystem.modules.user.entity.Role;
import com.softwarelabs.InventorySystem.modules.user.entity.User;
import com.softwarelabs.InventorySystem.modules.user.entity.UserRole;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface UserRoleRepo extends GenericRepo<UserRole, Long> {
    @Query("SELECT ur.role.idRole FROM UserRole ur WHERE ur.user.idUser = :userId")
    Set<Long> findRoleIdsByUserId(@Param("userId") Long userId);
    boolean existsByUserAndRole(User user, Role defaultRole);
}