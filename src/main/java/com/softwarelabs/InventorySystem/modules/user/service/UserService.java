package com.softwarelabs.InventorySystem.modules.user.service;

import com.softwarelabs.InventorySystem.modules.user.entity.User;

import java.util.List;

public interface UserService {
    User create(User user) throws Exception;
    List<User> getAllUsers() throws Exception;
    User update(Long id, User user) throws Exception;
    void deleteUser(Long id) throws Exception;
    User getUser(Long userId) throws Exception;
}