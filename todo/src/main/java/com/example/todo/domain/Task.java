package com.example.todo.domain;

import com.example.todo.exception.TaskDataInvalidException;
import jakarta.persistence.*;
import java.time.LocalDate;

// this class is the core domain entity representing a task
// persisted as a table in the H2 DB
@Entity
// explicitly set table name
@Table(name = "tasks")

public class Task {
    // primary key
    @Id
    // auto-increment ID
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String title;
    private String description;
    private LocalDate dueDate;
    private boolean completed;

    // protected constructor required by JPA
    protected Task() {
    }

    // factory method is the only way to create a task from outside
    // ensures all business rules are enforced
    public static Task create(String title, String description, LocalDate dueDate, Boolean completed) {
        Task task = new Task();

        // validate and set title
        task.changeTitle(title);
        // validate and set description
        task.changeDescription(description);
        // validate and set due date
        task.changeDueDate(dueDate);

        // optionally set completion status
        if (completed != null)
            task.completed = completed;

        return task;
    }

    // change task title
    public void changeTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new TaskDataInvalidException("Title cannot be empty");
        }
        if (title.length() < 3 || title.length() > 100) {
            throw new TaskDataInvalidException("Title must be 3-100 characters");
        }
        this.title = title;
    }

    // change task description
    public void changeDescription(String description) {
        if (description != null && description.length() > 200) {
            throw new TaskDataInvalidException("Description cannot exceed 200 characters");
        }
        this.description = description;
    }

    // change task due date
    public void changeDueDate(LocalDate dueDate) {
        if (dueDate != null && dueDate.isBefore(LocalDate.now())) {
            throw new TaskDataInvalidException("Due date cannot be in the past");
        }
        this.dueDate = dueDate;
    }

    public void markCompleted() {
        this.completed = true;
    }

    public void markIncomplete() {
        this.completed = false;
    }

    // getters only to ensure encapsulation
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public boolean isCompleted() {
        return completed;
    }
}