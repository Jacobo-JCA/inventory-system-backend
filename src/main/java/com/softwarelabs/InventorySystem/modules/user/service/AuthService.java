package com.softwarelabs.InventorySystem.modules.user.service;


public interface AuthService {
    void authenticate(String email, String password) throws Exception;
    String generateToken(String email) throws Exception;
}
