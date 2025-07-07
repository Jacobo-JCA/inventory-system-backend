package com.softwarelabs.InventorySystem.modules.user.service;

import com.softwarelabs.InventorySystem.modules.user.dto.RoleAssignmentDTO;


public interface UserRoleService {
    void assignDefaultRole(Long userId) throws Exception;
    void assignRoles(RoleAssignmentDTO roleAssignmentDTO) throws Exception;
}