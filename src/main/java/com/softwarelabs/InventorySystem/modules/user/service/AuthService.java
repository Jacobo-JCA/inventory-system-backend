package com.softwarelabs.InventorySystem.modules.user.service;

import com.softwarelabs.InventorySystem.modules.security.core.JwtRequest;

public interface AuthService {
    void authenticate(String email, String password) throws Exception;
    String getToken(JwtRequest req) throws Exception;
}
