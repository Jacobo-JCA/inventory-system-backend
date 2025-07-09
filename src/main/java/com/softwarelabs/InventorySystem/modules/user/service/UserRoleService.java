package com.softwarelabs.InventorySystem.modules.user.service;

import com.softwarelabs.InventorySystem.modules.user.dto.RoleAssignment;


public interface UserRoleService {
    void assignDefaultRole(Long userId) throws Exception;
    void assignRoles(RoleAssignment roleAssignment) throws Exception;
}