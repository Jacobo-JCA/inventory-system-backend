package com.softwarelabs.InventorySystem.modules.user.service.impl;

import com.softwarelabs.InventorySystem.modules.security.core.JwtRequest;
import com.softwarelabs.InventorySystem.modules.security.core.JwtResponse;
import com.softwarelabs.InventorySystem.modules.security.core.JwtUserDetailService;
import com.softwarelabs.InventorySystem.modules.security.core.JwtUtils;
import com.softwarelabs.InventorySystem.modules.user.dto.RegisterRequest;
import com.softwarelabs.InventorySystem.modules.user.dto.UserDTO;
import com.softwarelabs.InventorySystem.modules.user.entity.User;
import com.softwarelabs.InventorySystem.modules.user.exception.NotFoundException;
import com.softwarelabs.InventorySystem.modules.user.repo.UserRepo;
import com.softwarelabs.InventorySystem.modules.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.data.domain.Sort;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepo repo;
    private final JwtUserDetailService userDetailService;
    private final AuthenticationManager authenticationManager;
    private final ModelMapper mapper;
    private final JwtUtils jwtUtils;

    @Override
    public User registerUser(User registerRequest) {
        UserRole role = UserRole.MANAGER;
        if(registerRequest.getRole() != null) {
            role = registerRequest.getRole();
        }
        User userToSave = User.builder()
                .name(registerRequest.getName())
                .email(registerRequest.getEmail())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .phoneNumber(registerRequest.getPhoneNumber())
                .role(role)
                .build();
        repo.save(userToSave);
        return ResponseDTO.builder()
                .status(200)
                .message("user created successfully")
                .build();
    }

    private void authenticate(String username, String password) throws Exception {
            try {
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            } catch (DisabledException e) {
                throw new Exception("USER_DISABLED", e);
            } catch (BadCredentialsException e) {
                throw new Exception("INVALID_CREDENTIALS", e);
            }
    }

    @Override
    public JwtResponse loginUser(JwtRequest req) throws Exception {
        authenticate(req.getUsername(), req.getPassword());
        final UserDetails userDetails = userDetailService.loadUserByUsername(req.getUsername());
        final String token = jwtUtils.generatePayloadToken(userDetails);
        return new JwtResponse(token);
    }

    @Transactional
    @Override
    public ResponseDTO getAllUsers() {
        List<User> users = repo.findAll(Sort.by(Sort.Direction.DESC, "idUser"));
        List<UserDTO> userDTOs = mapper.map(users, new TypeToken<List<UserDTO>>() {}.getType());
        userDTOs.forEach(userDTO -> userDTO.setTransactions(null));
        return ResponseDTO.builder()
                .status(200)
                .message("success")
                .users(userDTOs)
                .build();
    }

    @Override
    public User updateUser(Long id, User user) {
        User existingUser = repo.findById(id)
                .orElseThrow(() -> new NotFoundException("User not Found"));
        if(userDTO.getEmail() != null) existingUser.setEmail(userDTO.getEmail());
        if(userDTO.getName() != null) existingUser.setName(userDTO.getName());
        if(userDTO.getPhoneNumber() != null) existingUser.setPhoneNumber(userDTO.getPhoneNumber());
        if(userDTO.getRole() != null) existingUser.setRole(userDTO.getRole());
        if(userDTO.getPassword() != null && !userDTO.getPassword().isEmpty()) {
            existingUser.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        }
        repo.save(existingUser);
        return ResponseDTO.builder()
                .status(200)
                .message("User Successfully updated")
                .build();
    }

    @Override
    public void deleteUser(Long id) {
        repo.findById(id)
                .orElseThrow(() -> new NotFoundException("User not Found"));
        repo.deleteById(id);
        return ResponseDTO.builder()
                .status(200)
                .message("User Successfully deleted")
                .build();
    }

    @Override
    public ResponseDTO getUserTransactions(Long id) {
        User user = repo.findById(id)
                .orElseThrow(() -> new NotFoundException("User not Found"));
        UserDTO userDTO = mapper.map(user, UserDTO.class);
        userDTO.getTransactions().forEach(transactionDto -> {
            transactionDto.setUser(null);
            transactionDto.setSupplier(null);
        });
        return ResponseDTO.builder()
                .status(200)
                .message("Success")
                .user(userDTO)
                .build();
    }
}
