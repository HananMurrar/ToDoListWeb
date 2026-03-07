package com.example.todo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// handles exceptions globally
@ControllerAdvice

public class GlobalExceptionHandler {
    // handle TaskNotFoundException → 404 not found
    @ExceptionHandler(TaskNotFoundException.class)
    public ResponseEntity<String> handleNotFound(TaskNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    // handle TaskDataInvalidException → 400 bad request
    @ExceptionHandler(TaskDataInvalidException.class)
    public ResponseEntity<String> handleInvalidData(TaskDataInvalidException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    // handle all other exceptions → 500 internal server error
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleOtherExceptions(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong, " + ex.getMessage());
    }
}