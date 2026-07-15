package com.projects.lovableClone.dto.auth;

//record type of class makes the fields immutable, we only have getter methods and no setters
public record AuthResponse(
        String token,
        UserProfileResponse user
) {
}
