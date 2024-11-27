package com.example.demospring.taskmanagementapi.service;

import com.example.demospring.taskmanagementapi.model.Project;
import com.example.demospring.taskmanagementapi.model.request.ProjectRequest;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface ProjectService {


    Project getProjectById(Long id);

    Project createProject(ProjectRequest projectRequest);

    Project updateProject(Long id, ProjectRequest projectRequest);

    void deleteProject(Long id);

    List<Project> getAllProject(Integer pageNo, Integer pageSize, String sortBy, Sort.Direction orderBy);
}
