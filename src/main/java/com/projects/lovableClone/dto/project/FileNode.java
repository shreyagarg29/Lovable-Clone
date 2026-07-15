package com.projects.lovableClone.dto.project;

import java.time.Instant;

public record FileNode(
        String path,
        Instant modifieedAt,
        Long size,
        String type
) {
}
