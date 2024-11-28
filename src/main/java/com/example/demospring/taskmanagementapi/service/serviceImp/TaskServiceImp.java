package com.example.demospring.taskmanagementapi.service.serviceImp;

import com.example.demospring.taskmanagementapi.exception.NotFoundException;
import com.example.demospring.taskmanagementapi.model.Project;
import com.example.demospring.taskmanagementapi.model.Task;
import com.example.demospring.taskmanagementapi.model.enumTask.EPriority;
import com.example.demospring.taskmanagementapi.model.request.TagRequest;
import com.example.demospring.taskmanagementapi.model.request.TaskRequest;
import com.example.demospring.taskmanagementapi.model.response.TaskResponse;
import com.example.demospring.taskmanagementapi.repository.ProjectRepository;
import com.example.demospring.taskmanagementapi.repository.TaskRepository;
import com.example.demospring.taskmanagementapi.service.ProjectService;
import com.example.demospring.taskmanagementapi.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskServiceImp implements TaskService {
    private final TaskRepository taskRepository;
    private final ProjectService projectService;

    public TaskServiceImp(TaskRepository taskRepository, ProjectService projectService) {
        this.taskRepository = taskRepository;
        this.projectService = projectService;
    }

    @Override
    public List<TaskResponse> getAllTask() {
//        return taskRepository.findAll().stream().map(Task::toResponse).toList();
        List<Task> tasks = taskRepository.findAll();
        List<TaskResponse> taskResponses = new ArrayList<>();
        for(Task task : tasks){
           taskResponses.add(task.toResponse());
        }
        return taskResponses;
    }

    @Override
    public TaskResponse getTaskById(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Task id "+id+" not found")
        );
        return task.toResponse();
    }

    @Override
    public Task createTask(TaskRequest taskRequest, EPriority priority) {
        Project project = projectService.getProjectById(taskRequest.getProjectId());
        return taskRepository.save(taskRequest.toEntity(priority,project));
    }

    @Override
    public Task updateTask(Long id, TaskRequest taskRequest, EPriority priority) {
        getTaskById(id);
        Project project = projectService.getProjectById(taskRequest.getProjectId());
        return taskRepository.save(taskRequest.toEntity(priority,project,id));
    }

    @Override
    public void deleteTask(Long id) {
       getTaskById(id);
       taskRepository.deleteById(id);
    }
}
