package com.example.demospring.taskmanagementapi.repository;

import com.example.demospring.taskmanagementapi.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task , Long> {
}
