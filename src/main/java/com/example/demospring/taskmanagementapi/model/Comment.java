package com.example.demospring.taskmanagementapi.model;

import com.example.demospring.taskmanagementapi.model.response.CommentResponse;
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
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;
    private String content;
    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    public CommentResponse toResponse(){
        return  new CommentResponse(this.commentId,this.content);
    }
}
