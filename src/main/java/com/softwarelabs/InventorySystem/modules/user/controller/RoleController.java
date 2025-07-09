package com.softwarelabs.InventorySystem.modules.user.controller;

import com.softwarelabs.InventorySystem.modules.user.common.mapper.RoleMapper;
import com.softwarelabs.InventorySystem.modules.user.dto.RoleAssignment;
import com.softwarelabs.InventorySystem.modules.user.dto.RoleResponseDTO;
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
    public ResponseEntity<Void> assignRolesToUser(@Valid @RequestBody RoleAssignment roleAssignment) throws Exception {
        userRoleService.assignRoles(roleAssignment);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/all")
    public ResponseEntity<List<RoleResponseDTO>> getAllRoles() throws Exception {
       List<RoleResponseDTO> roles = roleService.getAllRoles().stream()
               .map(RoleMapper::convertToDto)
               .toList();
       return new ResponseEntity<>(roles, HttpStatus.OK);
    }
}
