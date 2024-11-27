package com.example.demospring.taskmanagementapi.service;

import com.example.demospring.taskmanagementapi.model.Comment;
import com.example.demospring.taskmanagementapi.model.request.CommentRequest;
import com.example.demospring.taskmanagementapi.model.response.CommentResponse;

public interface CommentService {
    CommentResponse getCommentById(Long id);

    CommentResponse createComment(CommentRequest commentsRequest, Long taskId);

    void deleteCommentById(Long id);
}
