package com.example.demospring.taskmanagementapi.service.serviceImp;

import com.example.demospring.taskmanagementapi.exception.NotFoundException;
import com.example.demospring.taskmanagementapi.model.Tag;
import com.example.demospring.taskmanagementapi.model.Task;
import com.example.demospring.taskmanagementapi.model.TaskTag;
import com.example.demospring.taskmanagementapi.model.request.TagRequest;
import com.example.demospring.taskmanagementapi.repository.TagRepository;
import com.example.demospring.taskmanagementapi.repository.TaskRepository;
import com.example.demospring.taskmanagementapi.repository.TaskTagRepository;
import com.example.demospring.taskmanagementapi.service.TagService;
import com.example.demospring.taskmanagementapi.service.TaskService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TagServiceImp implements TagService {
    private final TagRepository tagRepository;
    private final TaskRepository taskRepository;
    private final TaskTagRepository taskTagRepository;

    public TagServiceImp(TagRepository tagRepository, TaskRepository taskRepository, TaskTagRepository taskTagRepository) {
        this.tagRepository = tagRepository;

        this.taskRepository = taskRepository;
        this.taskTagRepository = taskTagRepository;
    }

    @Override
    public List<Tag> getAllTag() {
        return tagRepository.findAll();
    }

    @Override
    public void assignTagToTask(Long taskId, Long tagId) {
        Tag tag = tagRepository.findById(tagId).orElseThrow(
                () -> new NotFoundException("Tag by id "+tagId+ " not found")
        );
        Task task = taskRepository.findById(taskId).orElseThrow(
                () -> new NotFoundException("Task by id "+taskId+" not found")
        );
        TaskTag taskTag = new TaskTag(null,task,tag);
        taskTagRepository.save(taskTag);
    }

    @Override
    public Tag createTag(TagRequest tagRequest) {
        return tagRepository.save(tagRequest.toEntity());
    }

    @Override
    public void deleteTagById(Long taskId, Long tagId) {
        Tag tag = tagRepository.findById(tagId).orElseThrow(
                () -> new NotFoundException("Tag by id "+tagId+ " not found")
        );
        Task task = taskRepository.findById(taskId).orElseThrow(
                () -> new NotFoundException("Task by id "+taskId+" not found")
        );
        taskTagRepository.deleteByTagAndTask(tag,task);
    }
}
