package com.example.todo.exception;

// custom exception for invalid task input
public class TaskDataInvalidException extends RuntimeException {
    public TaskDataInvalidException(String message) {
        // pass the friendly message to RuntimeException
        super(message);
    }
}