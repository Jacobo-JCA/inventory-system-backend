package com.softwarelabs.InventorySystem.modules.user.service.impl;

import com.softwarelabs.InventorySystem.modules.user.entity.Role;
import com.softwarelabs.InventorySystem.modules.user.exception.NotFoundException;
import com.softwarelabs.InventorySystem.modules.user.repo.RoleRepo;
import com.softwarelabs.InventorySystem.modules.user.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepo roleRepo;

    @Override
    public List<Role> getRolesById(List<Long> roleIds) throws Exception {
        return roleRepo.findAllById(roleIds);
    }

    @Override
    public List<Role> getAllRoles() throws Exception {
        return roleRepo.findAll();
    }

    @Override
    public Role findByRoleName(String roleName) throws Exception {
        return roleRepo.findByRoleName(roleName)
                .orElseThrow(() -> new NotFoundException("Not Found Role"));
    }
}
