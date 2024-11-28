package com.example.demospring.taskmanagementapi.repository;

import com.example.demospring.taskmanagementapi.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag , Long> {
}
