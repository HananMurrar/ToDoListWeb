package com.example.todo.repository;

import com.example.todo.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// marks this interface as a spring managed component that talks to the DB
@Repository

public interface TaskRepository extends JpaRepository<Task, Long> {
    // extending JpaRepository gives us ready-made CRUD methods:
    // save(task): add a new task or update an existing task
    // findAll(): get a list of all tasks from the database
    // findById(id): find a task by its ID
    // deleteById(id): delete a task by its ID

    // notes:
    // we do not need to write SQL queries ourselves, spring and JPA handle it
    // task generic type parameters: is entity class
    // long generic type parameters: is type of primary key, the ID in task entity
    // java persistence API, the JPA: is a standard that lets java objects be stored in DB
    // hibernate: is the actual engine that implements JPA
    // so the JPA it defines the rules, the actual implementation is done by hibernate
    // so TaskRepository class is the layer that connects java code to the DB
}