package com.example.demospring.taskmanagementapi.service;

import com.example.demospring.taskmanagementapi.model.Tag;
import com.example.demospring.taskmanagementapi.model.request.TagRequest;

import java.util.List;

public interface TagService {
    List<Tag> getAllTag();

    void assignTagToTask(Long taskId, Long tagId);

    Tag createTag(TagRequest tagRequest);

    void deleteTagById(Long taskId, Long tagId);
}
