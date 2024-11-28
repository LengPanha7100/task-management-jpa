package com.example.demospring.taskmanagementapi.model.response;

import com.example.demospring.taskmanagementapi.model.Task;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CommentResponse {
    private Long commentId;
    private String content;
}
