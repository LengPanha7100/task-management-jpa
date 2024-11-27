package com.example.demospring.taskmanagementapi.model.request;

import com.example.demospring.taskmanagementapi.model.Comment;
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
public class CommentRequest {
    private String content;

    public Comment toEntity(Task task){
        return new Comment(null,this.content,task);
    }
}
