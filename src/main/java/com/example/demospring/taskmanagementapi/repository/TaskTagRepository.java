package com.example.demospring.taskmanagementapi.repository;

import com.example.demospring.taskmanagementapi.model.Tag;
import com.example.demospring.taskmanagementapi.model.Task;
import com.example.demospring.taskmanagementapi.model.TaskTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskTagRepository extends JpaRepository<TaskTag , Long> {
    void deleteByTagAndTask (Tag tag , Task task);
}
