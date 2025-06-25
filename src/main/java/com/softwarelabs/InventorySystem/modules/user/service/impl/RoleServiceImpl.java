package com.softwarelabs.InventorySystem.modules.user.service.impl;

import com.softwarelabs.InventorySystem.modules.user.entity.Role;
import com.softwarelabs.InventorySystem.modules.user.entity.User;
import com.softwarelabs.InventorySystem.modules.user.exception.NotFoundException;
import com.softwarelabs.InventorySystem.modules.user.repo.RoleRepo;
import com.softwarelabs.InventorySystem.modules.user.service.RoleService;
import com.softwarelabs.InventorySystem.modules.user.service.UserRoleService;
import com.softwarelabs.InventorySystem.modules.user.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepo roleRepo;
    private final UserService userService;
    private final UserRoleService userRoleService;

    @Override
    public List<Role> getAllRoles() throws Exception {
        return roleRepo.findAll();
    }

    @Transactional
    @Override
    public void assignRole(Long userId, List<Long> rolesIds) throws Exception {
        User user = userService.getUser(userId);
        List<Role> roles = roleRepo.findAllById(rolesIds);
        if(roles.size() != rolesIds.size()) {
            throw new NotFoundException("Some roles not found");
        }
        roles.forEach(role -> {
            try {
                userRoleService.createUserRole(user, role);
            } catch (Exception e) {
                throw new NotFoundException("Not Created User Role");
            }
        });
    }
}
