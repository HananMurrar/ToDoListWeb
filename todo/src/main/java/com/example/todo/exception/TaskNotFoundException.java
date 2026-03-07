package com.example.todo.exception;

public class TaskNotFoundException extends RuntimeException {
    public TaskNotFoundException(String message) {
        // passes a friendly error message to RuntimeException
        super(message);
    }
}