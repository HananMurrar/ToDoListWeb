package com.example.todo.controller;

import com.example.todo.dto.TaskRequestDTO;
import com.example.todo.dto.TaskResponseDTO;
import com.example.todo.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// mark this class as REST API controller, so handle HTTP requests and all return values are JSON by default
@RestController
// base URL for all endpoints
@RequestMapping("/tasks")

public class TaskController {
    // inject TaskService to delegate business logic
    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    // create a new task
    // handles HTTP POST requests
    @PostMapping
    public ResponseEntity<TaskResponseDTO> createTask(@RequestBody TaskRequestDTO dto) {
        // @RequestBody maps JSON from client to TaskRequestDTO

        // call service to create a new task
        TaskResponseDTO response = service.createTask(dto);

        // return HTTP 201 with the created task as JSON
        return ResponseEntity.status(201).body(response);
    }

    // get all tasks
    // handles HTTP GET requests
    @GetMapping
    public ResponseEntity<List<TaskResponseDTO>> getAllTasks() {
        // call service to fetch all tasks
        List<TaskResponseDTO> tasks = service.getAllTasks();

        // return HTTP 200 with a JSON array of tasks
        return ResponseEntity.ok(tasks);
    }

    // get one task by ID
    // handles HTTP GET requests
    @GetMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> getTask(@PathVariable Long id) {
        // @PathVariable extracts {id} from the URL

        TaskResponseDTO task = service.getTask(id);

        // return HTTP 200 with the task as JSON
        return ResponseEntity.ok(task);
    }

    // update a task
    // handles HTTP PUT requests
    @PutMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> updateTask(@PathVariable Long id, @RequestBody TaskRequestDTO dto) {
        // call service to update the task
        TaskResponseDTO updated = service.updateTask(id, dto);

        // return HTTP 200 with updated task as JSON
        return ResponseEntity.ok(updated);
    }

    // delete a task
    // handles HTTP DELETE requests
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        // call service to delete the task
        service.deleteTask(id);

        // return HTTP 204 so deletion successful
        return ResponseEntity.noContent().build();
    }
}
