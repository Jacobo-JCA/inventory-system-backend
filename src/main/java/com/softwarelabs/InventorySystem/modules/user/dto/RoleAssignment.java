package com.softwarelabs.InventorySystem.modules.user.dto;



import java.util.List;

public record RoleAssignment(Long userId, List<Long> roleIds) {
}