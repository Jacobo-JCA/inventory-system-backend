package com.softwarelabs.InventorySystem.modules.user.service;

import com.softwarelabs.InventorySystem.modules.user.entity.Role;
import com.softwarelabs.InventorySystem.modules.user.entity.User;


public interface UserRoleService {
    void createUserRole(User user, Role role) throws Exception;
}
