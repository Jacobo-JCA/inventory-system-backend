package com.softwarelabs.InventorySystem.modules.user.common.mapper;


import com.softwarelabs.InventorySystem.modules.user.dto.UserRequestDTO;
import com.softwarelabs.InventorySystem.modules.user.dto.UserResponseDTO;
import com.softwarelabs.InventorySystem.modules.user.dto.UserUpdateDTO;
import com.softwarelabs.InventorySystem.modules.user.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;

public class UserMapper {
    @Qualifier("userMapper")
    private static final ModelMapper mapper = new ModelMapper();

    public static UserResponseDTO convertToDto(User obj) {
        return mapper.map(obj, UserResponseDTO.class);
    }

    public static User convertToEntity(UserRequestDTO dto) {
        return mapper.map(dto, User.class);
    }

    public static User convertToUpdateEntity(UserUpdateDTO dto) {
        return mapper.map(dto, User.class);
    }
}
