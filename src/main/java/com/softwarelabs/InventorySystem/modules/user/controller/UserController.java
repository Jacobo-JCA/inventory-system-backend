package com.softwarelabs.InventorySystem.modules.user.controller;

import com.softwarelabs.InventorySystem.modules.user.dto.LoginRequest;
import com.softwarelabs.InventorySystem.modules.user.dto.RegisterRequest;
import com.softwarelabs.InventorySystem.modules.user.dto.ResponseDTO;
import com.softwarelabs.InventorySystem.modules.user.dto.UserDTO;
import com.softwarelabs.InventorySystem.modules.user.entity.User;
import com.softwarelabs.InventorySystem.modules.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/users")
@RestController
public class UserController {
    private final UserService service;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/all")
    public ResponseEntity<ResponseDTO> getAllUsers() {
        return ResponseEntity.ok(service.getAllUsers());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> registerUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(service.updateUser(id, userDTO));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteUser(@PathVariable Long id) {
        return ResponseEntity.ok(service.deleteUser(id));
    }

    @GetMapping("/transaction/{id}")
    public ResponseEntity<ResponseDTO> getUserAndTransactions(@PathVariable Long id) {
        return ResponseEntity.ok(service.getUserTransactions(id));
    }

    @GetMapping("/current")
    public ResponseEntity<User> getCurrentUser() {
        return ResponseEntity.ok(service.getCurrentLoggedInUser());
    }
}
