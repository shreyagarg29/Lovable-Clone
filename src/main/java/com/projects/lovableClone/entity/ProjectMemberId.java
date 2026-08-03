package com.projects.lovableClone.entity;

import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectMemberId {
    // It will have the keys and it becomes the primary key

    Long projectId;
    Long userId;
}
