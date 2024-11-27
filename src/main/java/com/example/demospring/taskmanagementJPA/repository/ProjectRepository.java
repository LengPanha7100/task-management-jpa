package com.example.demospring.taskmanagementapi.repository;

import com.example.demospring.taskmanagementapi.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project , Long> {
}
