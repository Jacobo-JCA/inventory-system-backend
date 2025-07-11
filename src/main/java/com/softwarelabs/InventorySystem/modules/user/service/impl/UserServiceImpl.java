package com.softwarelabs.InventorySystem.modules.user.service.impl;

import com.softwarelabs.InventorySystem.modules.user.entity.User;
import com.softwarelabs.InventorySystem.modules.user.exception.EmailException;
import com.softwarelabs.InventorySystem.modules.user.exception.NotFoundException;
import com.softwarelabs.InventorySystem.modules.user.repo.UserRepo;
import com.softwarelabs.InventorySystem.modules.user.service.UserService;
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
    private final PasswordEncoder passwordEncoder;

    @Override
    public Long create(User user) throws Exception {
        if(repo.existsByEmail(user.getEmail())){
            throw new EmailException("Email already exist!");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User savedUser = repo.save(user);
        return savedUser.getIdUser();
    }

    @Override
    public List<User> getAllUsers() {
        return repo.findAll(Sort.by(Sort.Direction.DESC, "idUser"));
    }

    @Override
    public User getUser(Long userId) throws Exception {
        return repo.findById(userId).orElseThrow(() -> new NotFoundException("Not Found User"));
    }

    @Override
    public User update(Long id, User user) {
        user.setIdUser(id);
        User userExist = repo.findById(id).orElseThrow(() -> new NotFoundException("ID Not Found"));
        user.setPassword(userExist.getPassword());
        return repo.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        repo.findById(id).orElseThrow(() -> new NotFoundException("User not Found"));
        repo.deleteById(id);
    }
}
