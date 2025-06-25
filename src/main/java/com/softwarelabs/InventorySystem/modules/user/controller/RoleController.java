package com.softwarelabs.InventorySystem.modules.user.controller;

import com.softwarelabs.InventorySystem.modules.catalog.common.mapper.GenericMapper;
import com.softwarelabs.InventorySystem.modules.user.dto.RoleAssignmentDTO;
import com.softwarelabs.InventorySystem.modules.user.dto.RoleDTO;
import com.softwarelabs.InventorySystem.modules.user.service.RoleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/roles")
public class RoleController {
    private RoleService roleService;

    @PostMapping("/{userId}")
    public ResponseEntity<String> assignRoles(@PathVariable Long userId, @Valid @RequestBody RoleAssignmentDTO roleAssignmentDTO)
            throws Exception {
        roleService.assignRole(userId, roleAssignmentDTO.getRoleIds());
        return ResponseEntity.ok("Roles assigned successfully");
    }

    @GetMapping("/all")
    public ResponseEntity<List<RoleDTO>> getAllRoles() throws Exception {
       List<RoleDTO> roles = roleService.getAllRoles().stream()
               .map(r -> GenericMapper.convertToDto(r, RoleDTO.class))
               .toList();
       return new ResponseEntity<>(roles, HttpStatus.OK);
    }
}
