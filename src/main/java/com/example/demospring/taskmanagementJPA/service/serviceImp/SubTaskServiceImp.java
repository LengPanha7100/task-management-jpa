package com.example.demospring.taskmanagementapi.service.serviceImp;

import com.example.demospring.taskmanagementapi.exception.NotFoundException;
import com.example.demospring.taskmanagementapi.model.SubTask;
import com.example.demospring.taskmanagementapi.model.Task;
import com.example.demospring.taskmanagementapi.model.enumTask.EStatus;
import com.example.demospring.taskmanagementapi.model.request.SubTaskRequest;
import com.example.demospring.taskmanagementapi.model.response.SubTaskResponse;
import com.example.demospring.taskmanagementapi.repository.SubTaskRepository;
import com.example.demospring.taskmanagementapi.repository.TaskRepository;
import com.example.demospring.taskmanagementapi.service.SubTaskService;
import org.springframework.stereotype.Service;

@Service
public class SubTaskServiceImp implements SubTaskService {
    private final SubTaskRepository subTaskRepository;
    private final TaskRepository taskRepository;

    public SubTaskServiceImp(SubTaskRepository subTaskRepository, TaskRepository taskRepository) {
        this.subTaskRepository = subTaskRepository;
        this.taskRepository = taskRepository;
    }

    @Override
    public SubTaskResponse getSubTaskById(Long id) {
        SubTask subTask = subTaskRepository.findById(id).orElseThrow(
                () -> new NotFoundException("SubTask id "+id+" not found")
        );
        return subTask.toResponse();
    }

    @Override
    public SubTaskResponse createSubTask(SubTaskRequest subTaskRequest, Long taskId, EStatus status) {
        Task task = taskRepository.findById(taskId).orElseThrow(
                () -> new NotFoundException("Task id "+ taskId+" not found")
        );
        return subTaskRepository.save(subTaskRequest.toEntity(status,task)).toResponse();
    }

    @Override
    public SubTaskResponse updateSubTaskById(SubTaskRequest subTaskRequest, Long id, EStatus status) {
        SubTask subTask = subTaskRepository.findById(id).orElseThrow(
                () -> new NotFoundException("SubTask id "+id+" not found")
        );
        return subTaskRepository.save(subTaskRequest.toEntity(status,subTask.getTask(),id)).toResponse();
    }

    @Override
    public void deleteSubTaskById(Long id) {
        getSubTaskById(id);
        subTaskRepository.deleteById(id);
    }
}
