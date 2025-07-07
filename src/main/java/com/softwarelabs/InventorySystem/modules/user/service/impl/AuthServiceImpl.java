package com.softwarelabs.InventorySystem.modules.user.service.impl;

import com.softwarelabs.InventorySystem.modules.security.core.JwtRequest;
import com.softwarelabs.InventorySystem.modules.security.core.JwtUserDetailService;
import com.softwarelabs.InventorySystem.modules.security.core.JwtUtils;
import com.softwarelabs.InventorySystem.modules.user.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService  {
    private final AuthenticationManager authenticationManager;
    private final JwtUserDetailService userDetailService;
    private final JwtUtils jwtTokenUtil;

    @Override
    public void authenticate(String email, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

    @Override
    public String generateToken(String email) throws Exception {
        final UserDetails userDetails = userDetailService.loadUserByUsername(email);
        return jwtTokenUtil.generatePayloadToken(userDetails);
    }
}
