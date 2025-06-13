package com.softwarelabs.InventorySystem.modules.user.controller;

import com.softwarelabs.InventorySystem.modules.security.core.JwtRequest;
import com.softwarelabs.InventorySystem.modules.security.core.JwtResponse;
import com.softwarelabs.InventorySystem.modules.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {
        "http://localhost:4200",
        "https://5755-191-100-119-167.ngrok-free.app"
})
@RequiredArgsConstructor
@RequestMapping("/api/auth")
@RestController
public class AuthController {
    private final UserService service;

    @PostMapping("/register")
    public ResponseEntity<JwtResponse> registerUser(@RequestBody @Valid JwtRequest registerRequest) {
        return ResponseEntity.ok(service.registerUser(registerRequest));
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> loginUser(@RequestBody @Valid JwtRequest jwtRequest) throws Exception {
        return ResponseEntity.ok(service.loginUser(jwtRequest));
    }
}
