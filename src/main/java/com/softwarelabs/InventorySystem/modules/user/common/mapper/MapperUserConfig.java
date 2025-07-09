package com.softwarelabs.InventorySystem.modules.user.common.mapper;

import com.softwarelabs.InventorySystem.modules.user.dto.RoleResponseDTO;
import com.softwarelabs.InventorySystem.modules.user.dto.UserRequestDTO;
import com.softwarelabs.InventorySystem.modules.user.dto.UserResponseDTO;
import com.softwarelabs.InventorySystem.modules.user.dto.UserUpdateDTO;
import com.softwarelabs.InventorySystem.modules.user.entity.Role;
import com.softwarelabs.InventorySystem.modules.user.entity.User;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperUserConfig {
    @Bean("userMapper")
    public ModelMapper userMapper() {
        ModelMapper mapper = new ModelMapper();
        TypeMap<UserRequestDTO, User> type1 = mapper.createTypeMap(UserRequestDTO.class, User.class);
        TypeMap<UserUpdateDTO, User> type2 = mapper.createTypeMap(UserUpdateDTO.class, User.class);
        TypeMap<User, UserResponseDTO> type3 = mapper.createTypeMap(User.class, UserResponseDTO.class);
        return mapper;
    }

    @Bean("roleMapper")
    public ModelMapper roleMapper() {
        ModelMapper mapper = new ModelMapper();
        TypeMap<Role, RoleResponseDTO> type2 = mapper.createTypeMap(Role.class, RoleResponseDTO.class);
        return mapper;
    }
}
