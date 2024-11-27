package com.example.demospring.taskmanagementapi.model.request;

import com.example.demospring.taskmanagementapi.model.Tag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TagRequest {
    private String name;

    public Tag toEntity(){
        return new Tag(null,this.name,null);
    }



}
