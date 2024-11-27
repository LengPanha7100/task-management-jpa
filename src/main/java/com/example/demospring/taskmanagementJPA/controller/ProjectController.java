package com.example.demospring.taskmanagementapi.controller;

import com.example.demospring.taskmanagementapi.model.Project;
import com.example.demospring.taskmanagementapi.model.request.ProjectRequest;
import com.example.demospring.taskmanagementapi.model.response.APIResponse;
import com.example.demospring.taskmanagementapi.service.ProjectService;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/project")
public class ProjectController {
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public ResponseEntity<APIResponse<List<Project>>> getAllProject (@RequestParam (defaultValue = "1") Integer pageNo,
                                                                     @RequestParam (defaultValue =  "10") Integer pageSize,
                                                                     @RequestParam (defaultValue = "projectId") String sortBy,
                                                                     @RequestParam Sort.Direction orderBy){
        List<Project> project = projectService.getAllProject(pageNo,pageSize,sortBy,orderBy);
        APIResponse<List<Project>> apiResponse = APIResponse.<List<Project>>builder()
                .message("Get all the project successfully!")
                .status(HttpStatus.OK)
                .payload(project)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<Project>> getProjectById (@PathVariable Long id){
        Project project = projectService.getProjectById(id);
        APIResponse<Project> apiResponse = APIResponse.<Project>builder()
                .message("Get project by id successfully!")
                .status(HttpStatus.OK)
                .payload(project)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping
    public ResponseEntity<APIResponse<Project>> createProject (@RequestBody ProjectRequest projectRequest){
        Project project = projectService.createProject(projectRequest);
        APIResponse<Project> apiResponse = APIResponse.<Project>builder()
                .message("Created the project successfully!")
                .status(HttpStatus.OK)
                .payload(project)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<APIResponse<Project>> updateProject (@PathVariable Long id, @RequestBody ProjectRequest projectRequest){
        Project project = projectService.updateProject(id, projectRequest);
        APIResponse<Project> apiResponse = APIResponse.<Project>builder()
                .message("Updated project by id successfully!")
                .status(HttpStatus.OK)
                .payload(project)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse<Project>> deleteProject (@PathVariable Long id){
        projectService.deleteProject(id);
        APIResponse<Project> apiResponse = APIResponse.<Project>builder()
                .message("Deleted project by id successfully!")
                .status(HttpStatus.OK)
                .payload(null)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }


}
