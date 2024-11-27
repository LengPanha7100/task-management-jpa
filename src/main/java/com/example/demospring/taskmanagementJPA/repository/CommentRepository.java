package com.example.demospring.taskmanagementapi.repository;

import com.example.demospring.taskmanagementapi.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {
}
