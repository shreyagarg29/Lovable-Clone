package com.projects.lovableClone.dto.member;

import com.projects.lovableClone.enums.ProjectRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


public record InviteMemberRequest(
        @Email @NotBlank String email,
        @NotBlank ProjectRole role
) {
}
