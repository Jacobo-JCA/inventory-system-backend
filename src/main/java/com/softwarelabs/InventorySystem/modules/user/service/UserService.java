package com.softwarelabs.InventorySystem.modules.user.service;

import com.softwarelabs.InventorySystem.modules.security.core.JwtRequest;
import com.softwarelabs.InventorySystem.modules.security.core.JwtResponse;
import com.softwarelabs.InventorySystem.modules.user.entity.User;

public interface UserService {
    User registerUser(User registerRequest) throws Exception;
    JwtResponse loginUser(JwtRequest loginRequest) throws Exception;
    User getAllUsers() throws Exception;
    User updateUser(Long id, User user) throws Exception;
    void deleteUser(Long id) throws Exception;
}
