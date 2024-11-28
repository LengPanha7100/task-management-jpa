package com.example.demospring.taskmanagementapi.service.serviceImp;

import com.example.demospring.taskmanagementapi.exception.NotFoundException;
import com.example.demospring.taskmanagementapi.model.Project;
import com.example.demospring.taskmanagementapi.model.request.ProjectRequest;
import com.example.demospring.taskmanagementapi.repository.ProjectRepository;
import com.example.demospring.taskmanagementapi.service.ProjectService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImp implements ProjectService {
    private final ProjectRepository projectRepository;

    public ProjectServiceImp(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Project getProjectById(Long id) {
        Project project = projectRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Project id " + id + " not found")
        );
        return project;
    }

    @Override
    public Project createProject(ProjectRequest projectRequest) {
        return projectRepository.save(projectRequest.toEntity());
    }

    @Override
    public Project updateProject(Long id, ProjectRequest projectRequest) {
        getProjectById(id);
        return projectRepository.save(projectRequest.toEntity(id));
    }

    @Override
    public void deleteProject(Long id) {
        getProjectById(id);
       projectRepository.deleteById(id);
    }

    @Override
    public List<Project> getAllProject(Integer pageNo, Integer pageSize, String sortBy, Sort.Direction orderBy) {
        Pageable pageable = PageRequest.of(pageNo-1 , pageSize , Sort.by(orderBy,sortBy));
        Page<Project> projects = projectRepository.findAll(pageable);
        return projects.getContent();
    }
}
