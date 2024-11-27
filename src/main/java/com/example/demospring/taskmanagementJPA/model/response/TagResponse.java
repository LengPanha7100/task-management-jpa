package com.example.demospring.taskmanagementapi.model.response;

import com.example.demospring.taskmanagementapi.model.TaskTag;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class TagResponse {
    private Long tagId;
    private String name;
}
