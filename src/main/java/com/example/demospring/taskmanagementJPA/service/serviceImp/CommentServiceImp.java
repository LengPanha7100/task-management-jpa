package com.example.demospring.taskmanagementapi.service.serviceImp;

import com.example.demospring.taskmanagementapi.exception.NotFoundException;
import com.example.demospring.taskmanagementapi.model.Comment;
import com.example.demospring.taskmanagementapi.model.Task;
import com.example.demospring.taskmanagementapi.model.request.CommentRequest;
import com.example.demospring.taskmanagementapi.model.response.CommentResponse;
import com.example.demospring.taskmanagementapi.repository.CommentRepository;
import com.example.demospring.taskmanagementapi.repository.TaskRepository;
import com.example.demospring.taskmanagementapi.service.CommentService;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImp implements CommentService {
    private final CommentRepository commentRepository;
    private final TaskRepository taskRepository;

    public CommentServiceImp(CommentRepository commentRepository, TaskRepository taskRepository) {
        this.commentRepository = commentRepository;
        this.taskRepository = taskRepository;
    }

    @Override
    public CommentResponse getCommentById(Long id) {
        Comment comment = commentRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Comment by id "+id+" not found")
        );
        return comment.toResponse();
    }

    @Override
    public CommentResponse createComment(CommentRequest commentsRequest, Long taskId) {
        Task task = taskRepository.findById(taskId).orElseThrow(
                () -> new NotFoundException("Task by id "+taskId+ " not found")
        );
        return commentRepository.save(commentsRequest.toEntity(task)).toResponse();
    }

    @Override
    public void deleteCommentById(Long id) {
        getCommentById(id);
        commentRepository.deleteById(id);
    }
}
