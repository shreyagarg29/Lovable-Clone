package com.projects.lovableClone.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProjectFile {
    Long id;
    Project project;
    String path;
    String miniObjectKey; // MinIO is an S3-compatible, open-source object storage software
    Instant createdAt;
    Instant updatedAt;

    User createdBy;
    User updatedBy;
}
