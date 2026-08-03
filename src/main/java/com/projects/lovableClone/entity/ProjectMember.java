package com.projects.lovableClone.entity;

import com.projects.lovableClone.enums.ProjectRole;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

//join table - connects two tables
// Each project member will have a user and project, so two way mapping
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder // using builder pattern
@Table(name = "project_members")
public class ProjectMember {

    @EmbeddedId //as this is composite id
    ProjectMemberId id;

    @ManyToOne
    @MapsId("projectId") // --- using this we can take a part of embeddedId and assign that to other entity. If we didn't use mapsID and only used ManyToOne then this would create another projectId column which could throw error
    Project project; //--- if we used manytomany relation then it means we will have one join table with two columns - for project and user, but we want some more columns in our table. So new table will be created

    @ManyToOne
    @MapsId("userId")
    User user;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    ProjectRole projectRole;

    Instant invitedAt;
    Instant acceptedAt;
}
