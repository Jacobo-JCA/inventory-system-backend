package com.softwarelabs.InventorySystem.modules.user.service.impl;

import com.softwarelabs.InventorySystem.modules.user.entity.Role;
import com.softwarelabs.InventorySystem.modules.user.entity.User;
import com.softwarelabs.InventorySystem.modules.user.entity.UserRole;
import com.softwarelabs.InventorySystem.modules.user.exception.EmailAlreadyExistsException;
import com.softwarelabs.InventorySystem.modules.user.exception.NotFoundException;
import com.softwarelabs.InventorySystem.modules.user.repo.UserRepo;
import com.softwarelabs.InventorySystem.modules.user.service.RoleService;
import com.softwarelabs.InventorySystem.modules.user.service.UserRoleService;
import com.softwarelabs.InventorySystem.modules.user.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepo repo;
    private final UserRoleService userRoleService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User create(User user) throws Exception {
        if(repo.existsByEmail(user.getEmail())){
            throw new EmailAlreadyExistsException("Email already exist!");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        Role role = roleService.assignRole();
//        UserRole userRole = userRoleService.createUserRole(savedUser, role);
        //repo.save(user); debo verificar si el cascade sirve para quehibernate lo persista
        return repo.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return repo.findAll(Sort.by(Sort.Direction.DESC, "idUser"));
    }

    @Override
    public User update(Long id, User user) {
        repo.findById(id).orElseThrow(() -> new NotFoundException("User not Found"));
        return repo.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        repo.findById(id)
                .orElseThrow(() -> new NotFoundException("User not Found"));
        repo.deleteById(id);
    }

    @Override
    public User getUser(Long userId) throws Exception {
        return repo.findById(userId).orElseThrow(() -> new NotFoundException("Not Found User"));
    }
}
