package com.example.demospring.taskmanagementapi.model.response;

import com.example.demospring.taskmanagementapi.model.Task;
import com.example.demospring.taskmanagementapi.model.enumTask.EStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SubTaskResponse {
    private Long subTaskId;
    private String name;
    private EStatus status;

}
