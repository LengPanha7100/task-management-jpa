package com.example.demospring.taskmanagementapi.controller;

import com.example.demospring.taskmanagementapi.model.Task;
import com.example.demospring.taskmanagementapi.model.enumTask.EPriority;
import com.example.demospring.taskmanagementapi.model.request.TagRequest;
import com.example.demospring.taskmanagementapi.model.request.TaskRequest;
import com.example.demospring.taskmanagementapi.model.response.APIResponse;
import com.example.demospring.taskmanagementapi.model.response.TaskResponse;
import com.example.demospring.taskmanagementapi.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/task")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }


    @GetMapping
    public ResponseEntity<APIResponse<List<TaskResponse>>> getAllTask(){
        List<TaskResponse> TaskResponses = taskService.getAllTask();
        APIResponse<List<TaskResponse>> apiResponse = APIResponse.<List<TaskResponse>>builder()
                .message("Get all task successfully!")
                .status(HttpStatus.OK)
                .payload(TaskResponses)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<TaskResponse>> getTaskById(@PathVariable Long id){
        TaskResponse TaskResponse = taskService.getTaskById(id);
        APIResponse<TaskResponse> apiResponse = APIResponse.<TaskResponse>builder()
                .message("Get task by id successfully!")
                .status(HttpStatus.OK)
                .payload(TaskResponse)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping
    public ResponseEntity<APIResponse<Task>> createTask(@RequestBody TaskRequest taskRequest , @RequestParam EPriority ePriority){
        Task Task = taskService.createTask(taskRequest , ePriority);
        APIResponse<Task> apiResponse = APIResponse.<Task>builder()
                .message("Created task successfully!")
                .status(HttpStatus.CREATED)
                .payload(Task)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }
    @PutMapping("/{id}")
    public ResponseEntity<APIResponse<Task>> updateTask(@PathVariable Long id , @RequestBody TaskRequest taskRequest, @RequestParam EPriority ePriority){
        Task Task = taskService.updateTask(id,taskRequest,ePriority);
        APIResponse<Task> apiResponse = APIResponse.<Task>builder()
                .message("Updated task by id successfully!")
                .status(HttpStatus.OK)
                .payload(Task)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse<Task>> deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
        APIResponse<Task> apiResponse = APIResponse.<Task>builder()
                .message("Deleted task by id successfully!")
                .status(HttpStatus.OK)
                .payload(null)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }
}
