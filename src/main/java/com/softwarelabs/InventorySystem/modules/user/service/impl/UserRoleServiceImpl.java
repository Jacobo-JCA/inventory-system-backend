package com.softwarelabs.InventorySystem.modules.user.service.impl;

import com.softwarelabs.InventorySystem.modules.user.entity.Role;
import com.softwarelabs.InventorySystem.modules.user.entity.User;
import com.softwarelabs.InventorySystem.modules.user.entity.UserRole;
import com.softwarelabs.InventorySystem.modules.user.repo.UserRoleRepo;
import com.softwarelabs.InventorySystem.modules.user.service.UserRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserRoleServiceImpl implements UserRoleService {
    private final UserRoleRepo userRoleRepo;

    @Override
    public void createUserRole(User user, Role role) throws Exception {
        UserRole userRole = new UserRole();
        user.addAuthority(userRole);
        role.addAuthority(userRole);
        userRoleRepo.save(userRole);
    }
}
