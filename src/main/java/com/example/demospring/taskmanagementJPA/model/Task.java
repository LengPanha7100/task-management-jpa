package com.example.demospring.taskmanagementapi.model;

import com.example.demospring.taskmanagementapi.model.enumTask.EPriority;
import com.example.demospring.taskmanagementapi.model.response.CommentResponse;
import com.example.demospring.taskmanagementapi.model.response.SubTaskResponse;
import com.example.demospring.taskmanagementapi.model.response.TagResponse;
import com.example.demospring.taskmanagementapi.model.response.TaskResponse;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tasks")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;
    private String title;
    private String description;
    private LocalDate dueDate;
    @Enumerated(EnumType.STRING)
    private EPriority priority;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "project_id")
    private Project project;
    @OneToMany(mappedBy = "task",cascade = CascadeType.ALL)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<SubTask> subTaskList;
    @OneToMany(mappedBy = "task" , cascade = CascadeType.ALL)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Comment> comments;
    @OneToMany(mappedBy = "task",cascade = CascadeType.ALL)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TaskTag> taskTagList;

    public TaskResponse toResponse(){
        List<Tag> tags = new ArrayList<>();
        for (TaskTag taskTag : taskTagList){
            tags.add(taskTag.getTag());
        }
        List<TagResponse> tagResponses = new ArrayList<>();
        for(Tag tag :tags){
            tagResponses.add(tag.toResponse());
        }
        List<SubTaskResponse> subTaskResponses = new ArrayList<>();
        for(SubTask subTask : subTaskList){
            subTaskResponses.add(subTask.toResponse());
        }

        List<CommentResponse> commentResponses = new ArrayList<>();
        for(Comment comment : comments){
            commentResponses.add(comment.toResponse());
        }

        return new TaskResponse(this.taskId,this.title,this.description,this.priority,this.dueDate,project,tagResponses,subTaskResponses,commentResponses);
    }


}
