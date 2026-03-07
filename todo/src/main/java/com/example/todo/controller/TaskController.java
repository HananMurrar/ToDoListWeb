package com.example.todo.controller;

import com.example.todo.dto.TaskRequestDTO;
import com.example.todo.dto.TaskResponseDTO;
import com.example.todo.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// mark this class as REST controller, this means all methods return JSON and handle HTTP requests
@RestController
// base URL
@RequestMapping("/tasks")

public class TaskController {
    // inject TaskService to delegate business logic
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // create task
    // handles HTTP POST requests to "/tasks"
    @PostMapping
    public ResponseEntity<TaskResponseDTO> createTask(@RequestBody TaskRequestDTO dto) {
        // the @RequestBody converts JSON from the request into a TaskRequestDTO object

        // call service to create task and get the response DTO
        TaskResponseDTO response = taskService.createTask(dto);

        // return HTTP 200 ok with the created task in JSON
        return ResponseEntity.ok(response);
    }

    // get all tasks
    // handles HTTP GET requests to "/tasks"
    @GetMapping
    public ResponseEntity<List<TaskResponseDTO>> getAllTasks() {
        // call service to get all tasks
        List<TaskResponseDTO> tasks = taskService.getAllTasks();

        // return HTTP 200 ok with a JSON array of tasks
        return ResponseEntity.ok(tasks);
    }

    // get one task
    // handles HTTP GET requests to "/tasks/{id}"
    @GetMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> getTask(@PathVariable Long id) {
        // the @PathVariable extracts the {id} from the URL

        // call service to get task by ID
        TaskResponseDTO task = taskService.getTaskById(id);

        // return HTTP 200 ok with the task in JSON
        return ResponseEntity.ok(task);
    }

    // update task
    // handles HTTP PUT requests to "/tasks/{id}"
    @PutMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> updateTask(@PathVariable Long id, @RequestBody TaskRequestDTO dto) {
        // the @PathVariable extracts the ID from URL
        // the @RequestBody maps JSON input to TaskRequestDTO

        // call service to update task
        TaskResponseDTO updated = taskService.updateTask(id, dto);

        // return HTTP 200 ok with updated task in JSON
        return ResponseEntity.ok(updated);
    }

    // delete task
    // handles HTTP DELETE requests to "/tasks/{id}"
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        // call service to delete the task
        taskService.deleteTask(id);

        // return HTTP 204 no content, so deletion successful
        return ResponseEntity.noContent().build();
    }
}
