package com.softwarelabs.InventorySystem.modules.user.service;

import com.softwarelabs.InventorySystem.modules.user.dto.RoleAssignmentDTO;
import com.softwarelabs.InventorySystem.modules.user.entity.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAllRoles() throws Exception;
    Role findByRoleName(String roleName) throws Exception;
    Role getRoleById(Long roleId) throws Exception;
}
