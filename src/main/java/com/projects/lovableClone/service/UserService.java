package com.projects.lovableClone.service;

import com.projects.lovableClone.dto.auth.UserProfileResponse;

public interface UserService {
    UserProfileResponse getProfile(long userId);
}
