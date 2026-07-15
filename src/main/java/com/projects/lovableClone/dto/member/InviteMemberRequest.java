package com.projects.lovableClone.dto.member;

import com.projects.lovableClone.enums.ProjectRole;

public record InviteMemberRequest(
        String email,
        ProjectRole role
) {
}
