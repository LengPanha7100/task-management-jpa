package com.example.demospring.taskmanagementapi.controller;

import com.example.demospring.taskmanagementapi.model.Tag;
import com.example.demospring.taskmanagementapi.model.request.TagRequest;
import com.example.demospring.taskmanagementapi.model.response.APIResponse;
import com.example.demospring.taskmanagementapi.service.TagService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/tag")
public class TagController {
    private final TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }


    @GetMapping
    public ResponseEntity<APIResponse<List<Tag>>> getAllTag(){
        List<Tag> Tag = tagService.getAllTag();
        APIResponse<List<Tag>> apiResponse = APIResponse.<List<Tag>>builder()
                .message("Get all Tag successfully!")
                .status(HttpStatus.OK)
                .payload(Tag)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping("/{taskId}/Tag/{tagId}")
    public ResponseEntity<APIResponse<Tag>> assignTagToTask(@PathVariable Long taskId , @PathVariable Long tagId){
        tagService.assignTagToTask(taskId,tagId);
        APIResponse<Tag> apiResponse = APIResponse.<Tag>builder()
                .message("Assign Tag to Task successfully!")
                .status(HttpStatus.OK)
                .payload(null)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping
    public ResponseEntity<APIResponse<Tag>> createTag(@RequestBody TagRequest tagRequest){
        Tag Tag = tagService.createTag(tagRequest);
        APIResponse<Tag> apiResponse = APIResponse.<Tag>builder()
                .message("Created Tag successfully!")
                .status(HttpStatus.CREATED)
                .payload(Tag)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }


    @DeleteMapping("/{taskId}/Tag/{tagId}")
    public ResponseEntity<APIResponse<Tag>> deleteTagById(@PathVariable Long taskId , @PathVariable Long tagId){
        tagService.deleteTagById(taskId,tagId);
        APIResponse<Tag> apiResponse = APIResponse.<Tag>builder()
                .message("Remove Tag from Task successfully!")
                .status(HttpStatus.OK)
                .payload(null)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }
}
