package com.softwarelabs.InventorySystem.modules.user.service;

import com.softwarelabs.InventorySystem.modules.user.entity.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAllRoles() throws Exception;
    void assignRole(Long userId, List<Long> rolesIds) throws Exception;
}
