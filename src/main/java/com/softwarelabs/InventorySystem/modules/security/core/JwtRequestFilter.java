package com.softwarelabs.InventorySystem.modules.security.core;

import io.jsonwebtoken.JwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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

    private Optional<String> extractBearerToken(HttpServletRequest request) {
        return Optional.ofNullable(request.getHeader("Authorization"))
                .filter(header -> header.startsWith("Bearer ") || header.startsWith("bearer "))
                .map(header -> header.substring(7));
    }

    private void authenticationUser(UserDetails userDetails, HttpServletRequest request) {
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken
                (userDetails, null, userDetails.getAuthorities());
        authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authToken);
        log.debug("Authentication: {}", userDetails.getUsername());
    }

    private void validateToken(String email, String token, HttpServletRequest request) {
        Optional.ofNullable(email)
                .ifPresent(e -> {
                    UserDetails userDetails = jwtUserDetailService.loadUserByUsername(email);
                    if(jwtUtils.isTokenValid(token, userDetails)) {
                        authenticationUser(userDetails, request);
                    }
                });
    }

    private void extractEmail(String token, HttpServletRequest request) {
        try {
            String email = jwtUtils.getUsernameFromToken(token);
            validateToken(email, token, request);
        } catch (JwtException e) {
            request.setAttribute("exception", e.getMessage());
        }
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        extractBearerToken(request).ifPresent(token -> {
            extractEmail(token, request);
        });
        filterChain.doFilter(request, response);
    }
}

