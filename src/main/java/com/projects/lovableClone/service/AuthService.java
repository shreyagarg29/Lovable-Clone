package com.projects.lovableClone.service;

import com.projects.lovableClone.dto.auth.AuthResponse;
import com.projects.lovableClone.dto.auth.LoginRequest;
import com.projects.lovableClone.dto.auth.SignupRequest;

public interface AuthService {
    AuthResponse signup(SignupRequest request);

    AuthResponse login(LoginRequest request);
}
