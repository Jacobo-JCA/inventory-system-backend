package com.softwarelabs.InventorySystem.modules.user.dto;


import java.util.List;

public record RoleAssignmentDTO(Long userId, List<Long> roleIds) {
}
