package com.example.demospring.taskmanagementapi.service;

import com.example.demospring.taskmanagementapi.model.SubTask;
import com.example.demospring.taskmanagementapi.model.enumTask.EStatus;
import com.example.demospring.taskmanagementapi.model.request.SubTaskRequest;
import com.example.demospring.taskmanagementapi.model.response.SubTaskResponse;

public interface SubTaskService {
    SubTaskResponse getSubTaskById(Long id);

    SubTaskResponse createSubTask(SubTaskRequest subTaskRequest, Long taskId, EStatus status);

    SubTaskResponse updateSubTaskById(SubTaskRequest subTaskRequest, Long id, EStatus status);

    void deleteSubTaskById(Long id);
}
