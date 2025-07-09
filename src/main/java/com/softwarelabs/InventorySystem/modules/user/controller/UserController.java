package com.softwarelabs.InventorySystem.modules.user.controller;

import com.softwarelabs.InventorySystem.modules.user.common.mapper.UserMapper;
import com.softwarelabs.InventorySystem.modules.user.dto.UserRequestDTO;
import com.softwarelabs.InventorySystem.modules.user.dto.UserResponseDTO;
import com.softwarelabs.InventorySystem.modules.user.dto.UserUpdateDTO;
import com.softwarelabs.InventorySystem.modules.user.entity.User;
import com.softwarelabs.InventorySystem.modules.user.service.UserRoleService;
import com.softwarelabs.InventorySystem.modules.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/users")
@RestController
public class UserController {
    private final UserService service;
    private final UserRoleService userRoleService;

    @PostMapping("/register")
    public ResponseEntity<Long> registerUser(@RequestBody @Valid UserRequestDTO userRegisterDTO) throws Exception {
        User user = UserMapper.convertToEntity(userRegisterDTO);
        Long idUser = service.create(user);
        userRoleService.assignDefaultRole(idUser);
        return new ResponseEntity<>(idUser, HttpStatus.CREATED);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/all")
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() throws Exception {
        List<UserResponseDTO> users = service.getAllUsers().stream()
                .map(UserMapper::convertToDto)
                .toList();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<UserResponseDTO> updateUser(@PathVariable Long id, @RequestBody UserUpdateDTO userUpdateDTO) throws Exception {
        User user = service.update(id, UserMapper.convertToUpdateEntity(userUpdateDTO));
        return new ResponseEntity<>(UserMapper.convertToDto(user), HttpStatus.ACCEPTED);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) throws Exception {
        service.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}