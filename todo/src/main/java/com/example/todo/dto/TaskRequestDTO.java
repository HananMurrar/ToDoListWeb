package com.example.todo.dto;

import java.time.LocalDate;

// the DTO for receiving task data from client
// this object is used to map JSON input from HTTP requests
public class TaskRequestDTO {
    private String title;
    private String description;
    private LocalDate dueDate;
    private Boolean completed;

    // getters and setters for all fields
    // required for Spring @RequestBody mapping

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}