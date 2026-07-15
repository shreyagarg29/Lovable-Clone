package com.projects.lovableClone.dto.auth;

public record LoginRequest(
        String email,
        String password
) {
}
