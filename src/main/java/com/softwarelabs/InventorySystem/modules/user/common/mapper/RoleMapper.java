package com.softwarelabs.InventorySystem.modules.user.common.mapper;

import com.softwarelabs.InventorySystem.modules.user.dto.RoleResponseDTO;
import com.softwarelabs.InventorySystem.modules.user.entity.Role;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;

public class RoleMapper {
    @Qualifier("roleMapper")
    private static final ModelMapper mapper = new ModelMapper();

    public static RoleResponseDTO convertToDto(Role obj) {
        return mapper.map(obj, RoleResponseDTO.class);
    }

    public static Role convertToEntity(RoleResponseDTO dto) {
        return mapper.map(dto, Role.class);
    }
}
