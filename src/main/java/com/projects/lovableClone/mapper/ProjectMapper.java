package com.projects.lovableClone.mapper;

import com.projects.lovableClone.dto.project.ProjectResponse;
import com.projects.lovableClone.dto.project.ProjectSummaryResponse;
import com.projects.lovableClone.entity.Project;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

    //convert projectEntity to projectDto
    @Mapping(source = "owner", target = "user")
    ProjectResponse toProjectResponse(Project project);

    ProjectSummaryResponse toProjectSummaryResponse(Project project);

    List<ProjectSummaryResponse> toListOfProjectSummaryResponse(List<Project> projects);
}
