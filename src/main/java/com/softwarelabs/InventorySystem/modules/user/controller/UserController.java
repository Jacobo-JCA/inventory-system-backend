package com.softwarelabs.InventorySystem.modules.user.controller;

import com.softwarelabs.InventorySystem.modules.user.common.mapper.GenericMapper;
import com.softwarelabs.InventorySystem.modules.user.dto.UserDTO;
import com.softwarelabs.InventorySystem.modules.user.entity.User;
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

    @PostMapping("/register")
    public ResponseEntity<UserDTO> registerUser(@RequestBody @Valid UserDTO userRegisterDTO) throws Exception {
        User user = GenericMapper.convertToEntity(userRegisterDTO, User.class);
        UserDTO userDTO = GenericMapper.convertToDto(service.create(user), UserDTO.class);
        return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/all")
    public ResponseEntity<List<UserDTO>> getAllUsers() throws Exception {
        List<UserDTO> users = service.getAllUsers().stream()
                .map(u -> GenericMapper.convertToDto(u, UserDTO.class))
                .toList();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) throws Exception {
        userDTO.setIdUser(id);
        User user = service.update(id, GenericMapper.convertToEntity(userDTO, User.class));
        return new ResponseEntity<>(GenericMapper.convertToDto(user, UserDTO.class), HttpStatus.ACCEPTED);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) throws Exception {
        service.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

//    @GetMapping("/current")
//    public ResponseEntity<User> getCurrentUser() {
//        return ResponseEntity.ok(service.getCurrentLoggedInUser());
//    }
}
