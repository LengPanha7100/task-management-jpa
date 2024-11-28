package com.example.demospring.taskmanagementapi.model;

import com.example.demospring.taskmanagementapi.model.enumTask.EStatus;
import com.example.demospring.taskmanagementapi.model.response.SubTaskResponse;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "subtasks")
public class SubTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subTaskId;
    private String name;
    @Enumerated(EnumType.STRING)
    private EStatus status;
    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    public SubTaskResponse toResponse(){
        return new SubTaskResponse(this.subTaskId,this.name,status);
    }

}
