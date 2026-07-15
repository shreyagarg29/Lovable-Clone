package com.projects.lovableClone.service;

import com.projects.lovableClone.dto.project.ProjectRequest;
import com.projects.lovableClone.dto.project.ProjectResponse;
import com.projects.lovableClone.dto.project.ProjectSummaryResponse;
import org.jspecify.annotations.Nullable;

import java.util.List;

public interface ProjectService {
    List<ProjectSummaryResponse> getUserProjects(Long userId);

    ProjectResponse getUserProjectsById(Long id, Long userId);

    ProjectResponse createProject(ProjectRequest request, Long userId);

    ProjectResponse updateProject(Long id, Long userId);

    void setDelete(Long id, Long userId);
}
