package com.example.todo.exception;

// custom exception for when a task is not found in DB
public class TaskNotFoundException extends RuntimeException {
    public TaskNotFoundException(String message) {
        // pass the friendly message to RuntimeException
        super(message);
    }
}