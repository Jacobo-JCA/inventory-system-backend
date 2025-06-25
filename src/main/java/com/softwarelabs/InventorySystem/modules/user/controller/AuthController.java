package com.softwarelabs.InventorySystem.modules.user.controller;

import com.softwarelabs.InventorySystem.modules.security.core.JwtRequest;
import com.softwarelabs.InventorySystem.modules.security.core.JwtResponse;
import com.softwarelabs.InventorySystem.modules.user.service.AuthService;
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
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> loginUser(@RequestBody @Valid JwtRequest req) throws Exception {
        authService.authenticate(req.getEmail(), req.getPassword());
        String token = authService.getToken(req);
        return ResponseEntity.ok(new JwtResponse(token));
    }
}
