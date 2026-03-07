package com.example.todo.service;

import com.example.todo.dto.TaskRequestDTO;
import com.example.todo.dto.TaskResponseDTO;
import com.example.todo.exception.TaskDataInvalidException;
import com.example.todo.exception.TaskNotFoundException;
import com.example.todo.model.Task;
import com.example.todo.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

// marks this class as a service bean that can be injected into controllers
@Service

public class TaskService {
    // used to access the DB
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    // create new task
    public TaskResponseDTO createTask(TaskRequestDTO dto) {
        // check that input data is valid
        validateTask(dto);

        // check that input data is valid
        Task task = new Task();

        // set title, description, completed from DTO
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        if (dto.getCompleted() != null)
            task.setCompleted(dto.getCompleted());

        // save entity to DB
        Task saved = taskRepository.save(task);

        // convert saved entity to response DTO to return to client
        return toResponseDTO(saved);
    }

    // get all tasks
    public List<TaskResponseDTO> getAllTasks() {
        // call the repository to fetch all task entities from DB
        List<Task> tasks = taskRepository.findAll();

        // convert each task entity to TaskResponseDTO using a stream
        List<TaskResponseDTO> dtoList = tasks.stream().map(this::toResponseDTO).collect(Collectors.toList());

        // return the list of TaskResponseDTO to the controller
        return dtoList;
    }

    // get task by ID
    public TaskResponseDTO getTaskById(Long id) {
        // find the task by its ID
        Task task = taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException("Task not found with ID " + id));

        // convert the found task entity into a TaskResponseDTO
        TaskResponseDTO dto = toResponseDTO(task);

        // return the DTO to the controller for sending to the client
        return dto;
    }

    // update task
    public TaskResponseDTO updateTask(Long id, TaskRequestDTO dto) {
        validateTask(dto);

        Task task = taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException("Task not found with ID " + id));

        // update fields
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        if (dto.getCompleted() != null)
            task.setCompleted(dto.getCompleted());

        // save updated entity to DB
        Task updated = taskRepository.save(task);

        // return updated task as DTO
        return toResponseDTO(updated);
    }

    // delete task
    public void deleteTask(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException("Task not found with ID " + id));

        // delete task from DB
        taskRepository.delete(task);
    }

    // validation function for input data
    private void validateTask(TaskRequestDTO dto) {
        // title must not be null or empty
        if (dto.getTitle() == null || dto.getTitle().trim().isEmpty())
            throw new TaskDataInvalidException("Title cannot be empty");

        // title length must be between 3 and 100 characters
        if (dto.getTitle().length() < 3 || dto.getTitle().length() > 100)
            throw new TaskDataInvalidException("Title must be 3-100 characters long");

        // description max length 200 characters, optional field
        if (dto.getDescription() != null && dto.getDescription().length() > 200)
            throw new TaskDataInvalidException("Description cannot exceed 200 characters");
    }

    // convert task entity to response DTO
    private TaskResponseDTO toResponseDTO(Task task) {
        TaskResponseDTO dto = new TaskResponseDTO();

        // include ID, tittle, description, completion status in response
        dto.setId(task.getId());
        dto.setTitle(task.getTitle());
        dto.setDescription(task.getDescription());
        dto.setCompleted(task.isCompleted());

        // return DTO to controller
        return dto;
    }
}
