package com.projects.lovableClone.service.impl;

import com.projects.lovableClone.dto.project.ProjectRequest;
import com.projects.lovableClone.dto.project.ProjectResponse;
import com.projects.lovableClone.dto.project.ProjectSummaryResponse;
import com.projects.lovableClone.entity.Project;
import com.projects.lovableClone.entity.User;
import com.projects.lovableClone.mapper.ProjectMapper;
import com.projects.lovableClone.repository.ProjectRepository;
import com.projects.lovableClone.repository.UserRepository;
import com.projects.lovableClone.service.ProjectService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;
    private final ProjectMapper projectMapper;

    @Override
    public ProjectResponse createProject(ProjectRequest request, Long userId) {

        User owner = userRepository.findById(userId).orElseThrow();
        Project project = Project.builder()
                .projectName(request.projectName())
                .owner(owner).
                isPublic(false).
                build(); //createdAt, updatedAt auto generated and deletedAt is null

        project = projectRepository.save(project);

        return projectMapper.toProjectResponse(project);
    }

    @Override
    public List<ProjectSummaryResponse> getUserProjects(Long userId) {

       /* way 1 --- return projectRepository.findAllAccessibleByUser(userId)
                .stream()
                .map(projectMapper::toProjectSummaryResponse)
                .collect(Collectors.toList());

        // project -> projectMapper.toProjectSummaryResponse(project) line 48 meaning
    */

        var projects = projectRepository.findAllAccessibleByUser(userId);
        return projectMapper.toListOfProjectSummaryResponse(projects);
    }
    @Override
    public ProjectResponse getUserProjectsById(Long id, Long userId) {
        return null;
    }

    @Override
    public ProjectResponse updateProject(Long id, Long userId) {
        return null;
    }

    @Override
    public void setDelete(Long id, Long userId) {

    }
}
