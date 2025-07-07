package com.softwarelabs.InventorySystem.modules.user.controller;

import com.softwarelabs.InventorySystem.modules.user.common.mapper.GenericMapper;
import com.softwarelabs.InventorySystem.modules.user.dto.UserDTO;
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
    public ResponseEntity<Long> registerUser(@RequestBody @Valid UserDTO userRegisterDTO) throws Exception {
        User user = GenericMapper.convertToEntity(userRegisterDTO, User.class);
        Long idUser = service.create(user);
        userRoleService.assignDefaultRole(idUser);
        return new ResponseEntity<>(idUser, HttpStatus.CREATED);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/all")
    public ResponseEntity<List<UserDTO>> getAllUsers() throws Exception {
        List<UserDTO> users = service.getAllUsers().stream()
                .map(u -> GenericMapper.convertToDto(u, UserDTO.class))
                .toList();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<UserUpdateDTO> updateUser(@PathVariable Long id, @RequestBody UserUpdateDTO userUpdateDTO) throws Exception {
        userUpdateDTO.setIdUser(id);
        User user = service.update(id, GenericMapper.convertToEntity(userUpdateDTO, User.class));
        return new ResponseEntity<>(GenericMapper.convertToDto(user, UserUpdateDTO.class), HttpStatus.ACCEPTED);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) throws Exception {
        service.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}