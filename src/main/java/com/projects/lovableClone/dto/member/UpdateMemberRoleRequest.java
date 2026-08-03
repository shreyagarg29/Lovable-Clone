package com.projects.lovableClone.dto.member;

import com.projects.lovableClone.enums.ProjectRole;
import jakarta.validation.constraints.NotNull;

public record UpdateMemberRoleRequest(
        @NotNull ProjectRole role) {
}
