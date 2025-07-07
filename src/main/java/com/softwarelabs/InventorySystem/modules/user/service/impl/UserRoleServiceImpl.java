package com.softwarelabs.InventorySystem.modules.user.service.impl;

import com.softwarelabs.InventorySystem.modules.user.dto.RoleAssignmentDTO;
import com.softwarelabs.InventorySystem.modules.user.entity.Role;
import com.softwarelabs.InventorySystem.modules.user.entity.User;
import com.softwarelabs.InventorySystem.modules.user.entity.UserRole;
import com.softwarelabs.InventorySystem.modules.user.exception.NotFoundException;
import com.softwarelabs.InventorySystem.modules.user.exception.RoleException;
import com.softwarelabs.InventorySystem.modules.user.repo.UserRoleRepo;
import com.softwarelabs.InventorySystem.modules.user.service.RoleService;
import com.softwarelabs.InventorySystem.modules.user.service.UserRoleService;
import com.softwarelabs.InventorySystem.modules.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserRoleServiceImpl implements UserRoleService {
    private final UserRoleRepo userRoleRepo;
    private final UserService userService;
    private final RoleService roleService;

    @Override
    @Transactional
    public void assignDefaultRole(Long userId) throws Exception {
        User user = userService.getUser(userId);
        Role defaultRole = roleService.findByRoleName("ROLE_USER");
        if (userRoleRepo.existsByUserAndRole(user, defaultRole)) {
            throw new NotFoundException("Already Assignment!");
        }
        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(defaultRole);
        userRoleRepo.save(userRole);
    }

    @Transactional
    @Override
    public void assignRoles(RoleAssignmentDTO roleAssignmentDTO) throws Exception {
        User user = userService.getUser(roleAssignmentDTO.userId());
        Set<Long> existingRoleIds = userRoleRepo.findRoleIdsByUserId(user.getIdUser());
        Set<Long> duplicateRoleIds = roleAssignmentDTO.roleIds().stream()
                .filter(existingRoleIds::contains)
                .collect(Collectors.toSet());
        if (!duplicateRoleIds.isEmpty()) {
            String duplicateIds = duplicateRoleIds.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", "));
            throw new RoleException("The following roles are already assigned: " + duplicateIds);
        }
        List<Role> newRoles = roleAssignmentDTO.roleIds().stream()
                .map(roleId -> {
                    try {
                        return roleService.getRoleById(roleId);
                    } catch (Exception e) {
                        throw new RoleException("ID Role Not Found: " + roleId + e.getMessage());
                    }
                })
                .toList();
        boolean hasAdminRole = newRoles.stream()
                .anyMatch(role -> "ROLE_ADMIN".equals(role.getRoleName()));
        if (hasAdminRole) {
            throw new RoleException("Cannot assign ADMIN role");
        }
        newRoles.forEach(role -> {
            UserRole userRole = new UserRole();
            user.addAuthority(userRole);
            role.addAuthority(userRole);
            userRoleRepo.save(userRole);
        });
    }
}
