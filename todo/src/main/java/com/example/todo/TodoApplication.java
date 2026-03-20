package com.example.todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class TodoApplication {
    public static void main(String[] args) {
        // run the spring boot application
        // this starts the embedded Tomcat server and initializes all beans
        SpringApplication.run(TodoApplication.class, args);
    }
}