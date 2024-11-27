package com.example.demospring.taskmanagementapi.controller;

import com.example.demospring.taskmanagementapi.model.SubTask;
import com.example.demospring.taskmanagementapi.model.enumTask.EStatus;
import com.example.demospring.taskmanagementapi.model.request.SubTaskRequest;
import com.example.demospring.taskmanagementapi.model.response.APIResponse;
import com.example.demospring.taskmanagementapi.model.response.SubTaskResponse;
import com.example.demospring.taskmanagementapi.service.SubTaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("api/v1/subtask")
public class SubTaskController {
    private final SubTaskService subTaskService;

    public SubTaskController(SubTaskService subTaskService) {
        this.subTaskService = subTaskService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<SubTaskResponse>> getSubTaskById(@PathVariable Long id){
        SubTaskResponse  subTasks = subTaskService.getSubTaskById(id);
        APIResponse<SubTaskResponse> apiResponse = APIResponse.<SubTaskResponse>builder()
                .message("Get subTask by id successfully!")
                .status(HttpStatus.OK)
                .payload(subTasks)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }
    @PostMapping("/{taskId}")
    public ResponseEntity<APIResponse<SubTaskResponse>> createSubTask(@RequestBody SubTaskRequest subTaskRequest,
                                                              @PathVariable Long taskId ,
                                                              @RequestParam EStatus status){
        SubTaskResponse subTasks = subTaskService.createSubTask(subTaskRequest,taskId,status);
        APIResponse<SubTaskResponse> apiResponse = APIResponse.<SubTaskResponse>builder()
                .message("Created subTask successfully!")
                .status(HttpStatus.CREATED)
                .payload(subTasks)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }


    @PutMapping("/{id}")
    public ResponseEntity<APIResponse<SubTaskResponse>> updateSubTaskById(@PathVariable Long id ,
                                                                  @RequestBody SubTaskRequest subTaskRequest,
                                                                  @RequestParam EStatus status){
        SubTaskResponse  subTasks = subTaskService.updateSubTaskById(subTaskRequest, id,status);
        APIResponse<SubTaskResponse> apiResponse = APIResponse.<SubTaskResponse>builder()
                .message("Updated subTask by id successfully!")
                .status(HttpStatus.OK)
                .payload(subTasks)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse<SubTask>> deleteSubTaskById(@PathVariable Long id ){
        subTaskService.deleteSubTaskById( id);
        APIResponse<SubTask> apiResponse = APIResponse.<SubTask>builder()
                .message("Deleted subTask by id successfully!")
                .status(HttpStatus.OK)
                .payload(null)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }

}
