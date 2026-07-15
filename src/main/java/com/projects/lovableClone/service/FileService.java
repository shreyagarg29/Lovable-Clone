package com.projects.lovableClone.service;

import com.projects.lovableClone.dto.project.FileContentResponse;
import com.projects.lovableClone.dto.project.FileNode;

import java.util.List;

public interface FileService {
    List<FileNode> getFileTree(Long projectId, Long userId);

    FileContentResponse getFileContent(Long projectId, String path, Long userId);
}
