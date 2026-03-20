package com.example.todo.service;

import com.example.todo.domain.Task;
import com.example.todo.dto.TaskRequestDTO;
import com.example.todo.dto.TaskResponseDTO;
import com.example.todo.exception.TaskNotFoundException;
import com.example.todo.repository.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

// marks this class as service layer
// contains business orchestration
@Service
// ensures atomic operations on DB
@Transactional

public class TaskService {
    // used to access the DB
    private final TaskRepository repository;

    // constructor injection
    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    // create a new task
    public TaskResponseDTO createTask(TaskRequestDTO dto) {
        // create domain object
        Task task = Task.create(dto.getTitle(), dto.getDescription(), dto.getDueDate(), dto.getCompleted());

        // save task in DB
        Task saved = repository.save(task);

        // convert to response DTO
        return toResponseDTO(saved);
    }

    // get all tasks
    public List<TaskResponseDTO> getAllTasks() {
        // convert all tasks from DB to DTOs
        return repository.findAll().stream().map(this::toResponseDTO).toList();
    }

    // get task by ID
    public TaskResponseDTO getTask(Long id) {
        Task task = repository.findById(id).orElseThrow(() -> new TaskNotFoundException("Task not found with ID " + id));

        return toResponseDTO(task);
    }

    // update task
    public TaskResponseDTO updateTask(Long id, TaskRequestDTO dto) {
        // find existing task
        Task task = repository.findById(id).orElseThrow(() -> new TaskNotFoundException("Task not found with ID " + id));

        // apply domain rules to update fields
        task.changeTitle(dto.getTitle());
        task.changeDescription(dto.getDescription());
        task.changeDueDate(dto.getDueDate());

        // update completion status if provided
        if (dto.getCompleted() != null) {
            if (dto.getCompleted()) task.markCompleted();
            else task.markIncomplete();
        }

        // save updated task
        Task updated = repository.save(task);

        // return as DTO
        return toResponseDTO(updated);
    }

    // delete task
    public void deleteTask(Long id) {
        Task task = repository.findById(id).orElseThrow(() -> new TaskNotFoundException("Task not found with ID " + id));

        repository.delete(task);
    }

    // convert domain object to DTO
    private TaskResponseDTO toResponseDTO(Task task) {
        TaskResponseDTO dto = new TaskResponseDTO();

        dto.setId(task.getId());
        dto.setTitle(task.getTitle());
        dto.setDescription(task.getDescription());
        dto.setDueDate(task.getDueDate());
        dto.setCompleted(task.isCompleted());

        return dto;
    }
}