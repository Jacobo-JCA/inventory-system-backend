package com.softwarelabs.InventorySystem.modules.user.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RoleAssignmentDTO {
    @NotEmpty(message = "Ids Not empty")
    private List<Long> roleIds = new ArrayList<>(4);
}
