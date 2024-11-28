package com.example.demospring.taskmanagementapi.model.request;

import com.example.demospring.taskmanagementapi.model.Project;
import com.example.demospring.taskmanagementapi.model.Task;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ProjectRequest {
    private String name;
    private String description;
    public Project toEntity(){
        return new Project(null,this.name,this.description,null);
    }
    public Project toEntity(Long id){
        return new Project(id , this.name,this.description,null);
    }

}
