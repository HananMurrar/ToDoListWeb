package com.example.todo.exception;

public class TaskDataInvalidException extends RuntimeException {
    public TaskDataInvalidException(String message) {
        // passes a friendly error message to RuntimeException
        super(message);
    }
}