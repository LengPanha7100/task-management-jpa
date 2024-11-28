package com.example.demospring.taskmanagementapi.model.request;

import com.example.demospring.taskmanagementapi.model.Project;
import com.example.demospring.taskmanagementapi.model.Task;
import com.example.demospring.taskmanagementapi.model.enumTask.EPriority;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskRequest {
    private String title;
    private String description;
    private LocalDate dueDate;
    private Long projectId;

    public Task toEntity(EPriority priority , Project project){
        return new Task(null,this.title,this.description,this.dueDate,priority,project,null,null,null);
    }

    public Task toEntity(EPriority priority , Project project , Long id){
        return new Task(id,this.title,this.description,this.dueDate,priority,project,null,null,null);
    }
}
