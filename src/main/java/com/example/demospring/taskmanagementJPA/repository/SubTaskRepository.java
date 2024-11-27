package com.example.demospring.taskmanagementapi.repository;

import com.example.demospring.taskmanagementapi.model.SubTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubTaskRepository extends JpaRepository<SubTask,Long> {
}
