package com.softwarelabs.InventorySystem.modules.user.controller;

import com.softwarelabs.InventorySystem.modules.catalog.common.mapper.GenericMapper;
import com.softwarelabs.InventorySystem.modules.user.dto.RoleAssignmentDTO;
import com.softwarelabs.InventorySystem.modules.user.dto.RoleDTO;
import com.softwarelabs.InventorySystem.modules.user.entity.Role;
import com.softwarelabs.InventorySystem.modules.user.service.RoleService;
import com.softwarelabs.InventorySystem.modules.user.service.UserRoleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/roles")
public class RoleController {
    private final RoleService roleService;
    private final UserRoleService userRoleService;

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/assign")
    public ResponseEntity<Void> assignRolesToUser(@Valid @RequestBody RoleAssignmentDTO roleAssignmentDTO) throws Exception {
        userRoleService.assignRoles(roleAssignmentDTO);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<RoleDTO>> getAllRoles() throws Exception {
       List<RoleDTO> roles = roleService.getAllRoles().stream()
               .map(r -> GenericMapper.convertToDto(r, RoleDTO.class))
               .toList();
       return new ResponseEntity<>(roles, HttpStatus.OK);
    }
}
