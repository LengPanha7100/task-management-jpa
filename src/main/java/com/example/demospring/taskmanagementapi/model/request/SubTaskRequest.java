package com.example.demospring.taskmanagementapi.model.request;

import com.example.demospring.taskmanagementapi.model.SubTask;
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
public class SubTaskRequest {
    private String name;

    public SubTask toEntity(EStatus status , Task task){
        return new SubTask(null, this.name,status,task);
    }
    public SubTask toEntity(EStatus status , Task task , Long id ){
        return new SubTask(id, this.name,status,task);
    }

}
