package com.example.demospring.taskmanagementapi.service;

import com.example.demospring.taskmanagementapi.model.Task;
import com.example.demospring.taskmanagementapi.model.enumTask.EPriority;
import com.example.demospring.taskmanagementapi.model.request.TagRequest;
import com.example.demospring.taskmanagementapi.model.request.TaskRequest;
import com.example.demospring.taskmanagementapi.model.response.TaskResponse;

import java.util.List;

public interface TaskService {
    List<TaskResponse> getAllTask();

    TaskResponse getTaskById(Long id);

    Task createTask(TaskRequest taskRequest, EPriority ePriority);

    Task updateTask(Long id, TaskRequest taskRequest, EPriority ePriority);

    void deleteTask(Long id);
}
