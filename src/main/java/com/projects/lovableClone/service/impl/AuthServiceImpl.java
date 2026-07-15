package com.projects.lovableClone.service.impl;

import com.projects.lovableClone.dto.auth.AuthResponse;
import com.projects.lovableClone.dto.auth.LoginRequest;
import com.projects.lovableClone.dto.auth.SignupRequest;
import com.projects.lovableClone.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Override
    public AuthResponse signup(SignupRequest request) {
        return null;
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        return null;
    }
}
