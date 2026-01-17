package com.example.demo.config;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.example.demo.model.User;
import lombok.Builder;

@Builder
public record JWTUserData(Long userId, String email, User.Role role) {

    public List<GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.getAuthority()));
    }

}
