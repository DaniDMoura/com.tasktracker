package com.tasktracker.controller;

import com.tasktracker.dto.TaskCreateDTO;
import com.tasktracker.dto.TaskResponseDTO;
import com.tasktracker.entity.Task;
import com.tasktracker.repository.TaskRepository;
import com.tasktracker.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/")
    public ResponseEntity<List<TaskResponseDTO>> listTasks() {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.findAll());
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<TaskResponseDTO> getTaskById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.findById(id));
    }

    @PostMapping("/")
    public ResponseEntity<TaskResponseDTO> createTask(@RequestBody TaskCreateDTO task) {
        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.createTask(task));
    }

    @PutMapping("/{taskId}")
    public ResponseEntity<TaskResponseDTO> updateTask(@PathVariable Long id, @RequestBody TaskCreateDTO task) {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.updateTask(id, task));
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<Void> updateTask(@PathVariable Long id) {
        taskService.deleteTask(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
