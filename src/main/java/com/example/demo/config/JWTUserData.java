package com.example.demo.config;

import com.example.demo.model.User;
import lombok.Builder;

@Builder
public record JWTUserData(Long userId, String email , User.Role role) {
}
