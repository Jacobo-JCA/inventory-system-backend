package com.softwarelabs.InventorySystem.modules.user.controller;

import com.softwarelabs.InventorySystem.modules.security.core.JwtRequest;
import com.softwarelabs.InventorySystem.modules.security.core.JwtResponse;
import com.softwarelabs.InventorySystem.modules.user.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/auth")
@RestController
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> loginUser(@RequestBody JwtRequest req) throws Exception {
        authService.authenticate(req.getEmail(), req.getPassword());
        String token = authService.generateToken(req.getEmail());
        return ResponseEntity.ok(new JwtResponse(token));
    }
}
