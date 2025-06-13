package com.softwarelabs.InventorySystem.modules.security.core;

import io.jsonwebtoken.JwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Component
public class JwtRequestFilter extends OncePerRequestFilter {
    private final JwtUtils jwtUtils;
    private final JwtUserDetailService jwtUserDetailService;

    private Optional<String> extractHeaderToken(HttpServletRequest request) {
        return Optional.ofNullable(request.getHeader("Authorization"))
                .filter(header -> header.length() > 7)
                .map(String::toLowerCase)
                .filter(header -> header.startsWith("bearer "))
                .map(header -> header.substring(7));
    }

    private void authenticationUser(UserDetails userDetails, HttpServletRequest request) {
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken
                (userDetails, null, userDetails.getAuthorities());
        authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authToken);
        log.debug("Authentication: {}", userDetails.getUsername());
    }

    private void authenticateUser(String email, String token, HttpServletRequest request) {
        UserDetails userDetails = jwtUserDetailService.loadUserByUsername(email);
        if(jwtUtils.isTokenValid(token, userDetails)) {
            authenticationUser(userDetails, request);
        }
    }

    private void validateToken(String token, HttpServletRequest request) {
        try {
            String email = jwtUtils.getUsernameFromToken(token);
            authenticateUser(email, token, request);
        } catch (JwtException e) {
            request.setAttribute("exception", e.getMessage());
        }
    }

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain) throws ServletException, IOException {
        extractHeaderToken(request).ifPresent(token -> {
            validateToken(token, request);
        });
        filterChain.doFilter(request, response);
    }
}

