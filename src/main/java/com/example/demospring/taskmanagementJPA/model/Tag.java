package com.example.demospring.taskmanagementapi.model;

import com.example.demospring.taskmanagementapi.model.response.TagResponse;
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
@Entity
@Table(name = "tags")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tagId;
    private String name;
    @OneToMany(mappedBy = "tag",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<TaskTag> taskTagList;

    public TagResponse toResponse(){
        return new TagResponse(this.tagId,this.name);
    }
}
