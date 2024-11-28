package com.example.demospring.taskmanagementapi.controller;

import com.example.demospring.taskmanagementapi.model.Comment;
import com.example.demospring.taskmanagementapi.model.request.CommentRequest;
import com.example.demospring.taskmanagementapi.model.response.APIResponse;
import com.example.demospring.taskmanagementapi.model.response.CommentResponse;
import com.example.demospring.taskmanagementapi.service.CommentService;
import org.hibernate.annotations.Comments;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("api/v1/comment")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<CommentResponse>> getCommentById(@PathVariable Long id){
        CommentResponse comments = commentService.getCommentById(id);
        APIResponse<CommentResponse> apiResponse = APIResponse.<CommentResponse>builder()
                .message("Get comment by id successfully!")
                .status(HttpStatus.OK)
                .payload(comments)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping("/{taskId}")
    public ResponseEntity<APIResponse<CommentResponse>> createComment(@RequestBody CommentRequest commentsRequest , @PathVariable Long taskId) {
        CommentResponse comment = commentService.createComment(commentsRequest,taskId);
        APIResponse<CommentResponse> apiResponse = APIResponse.<CommentResponse>builder()
                .message("Created comment successfully!")
                .status(HttpStatus.CREATED)
                .payload(comment)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse<Comment>> deleteCommentById(@PathVariable Long id){
        commentService.deleteCommentById(id);
        APIResponse<Comment> apiResponse = APIResponse.<Comment>builder()
                .message("Deleted comment by id successfully!")
                .status(HttpStatus.OK)
                .payload(null)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }
}
