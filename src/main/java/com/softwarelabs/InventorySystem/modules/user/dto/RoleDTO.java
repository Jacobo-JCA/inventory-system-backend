package com.softwarelabs.InventorySystem.modules.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RoleDTO {
    private Long idRole;
    private String roleName;
}
