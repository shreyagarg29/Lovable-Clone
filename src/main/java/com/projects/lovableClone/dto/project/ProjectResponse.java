package com.projects.lovableClone.dto.project;

import com.projects.lovableClone.dto.auth.UserProfileResponse;

import java.time.Instant;

public record ProjectResponse(
        Long id,
        String projectName,
        Instant createdAt,
        Instant updatedAt,
        UserProfileResponse user
) {
}
