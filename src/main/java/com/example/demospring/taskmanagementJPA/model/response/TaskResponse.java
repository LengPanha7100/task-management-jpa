package com.example.demospring.taskmanagementapi.model.response;

import com.example.demospring.taskmanagementapi.model.Comment;
import com.example.demospring.taskmanagementapi.model.Project;
import com.example.demospring.taskmanagementapi.model.SubTask;
import com.example.demospring.taskmanagementapi.model.Tag;
import com.example.demospring.taskmanagementapi.model.enumTask.EPriority;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TaskResponse {
    private Long taskId;
    private String title;
    private String description;
    private EPriority priority;
    private LocalDate dueDate;
    private Project project;
    private List<TagResponse> tags;
    private List<SubTaskResponse> subTasks;
    private List<CommentResponse> comments;

}
