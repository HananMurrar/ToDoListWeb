package com.example.todo.repository;

import com.example.todo.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// marks this interface as a Spring-managed component
// responsible for DB operations
@Repository

public interface TaskRepository extends JpaRepository<Task, Long> {
    // extending JpaRepository gives us built-in CRUD operations:
    // save(task): add or update a task
    // findAll(): get all tasks
    // findById(id): find task by ID
    // deleteById(id): delete task by ID

    // notes:
    // we do not need to write SQL queries ourselves, Spring and JPA handle it
    // task generic type parameters: is entity class
    // long generic type parameters: is type of primary key, the ID in task entity
    // the Java persistence API, the JPA: is a standard that lets Java objects be stored in DB
    // hibernate: is the actual engine that implements JPA
    // so the JPA it defines the rules, the actual implementation is done by hibernate
    // so TaskRepository class is the layer that connects Java code to the DB
}