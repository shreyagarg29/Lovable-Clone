package com.projects.lovableClone.entity;

import com.projects.lovableClone.enums.ProjectRole;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.time.Instant;

//join table - connects two tables
// Each project member will have a user and project, so two way mapping
public class ProjectMember {
    ProjectMemberId id;

    Project project;
    User user;

    ProjectRole projectRole;
    Instant invitedAt;
    Instant acceptedAt;
}
