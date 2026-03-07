### To do list web
The to-do list is a web application built with Spring Boot that allows users to create, read, update, delete (CRUD) tasks from a web page

#### Steps:
##### 1. Go to Spring initializr:
      https://start.spring.io
      
##### 2. Create a new project with these settings:
- Project: Maven
- Language: Java
- Spring Boot: 4.0.3
- Project metadata: group: com.example, artifact: todo, Java version: 17
- Dependencies: Spring web, Spring data JPA, H2 database

##### 3. Download and extract:
- Click generate to download the ZIP file
- Extract it to a folder on your computer

##### 4. Open in IntelliJ:
- Open the IntelliJ, select open then choose the extracted folder

##### 5. Create this structure:
```
📁 todo/
└── src/
    └── main/java/com/example/todo/
        ├── TodoApplication.java

        ├── controller/
            └── TaskController.java
        ├── service/
            └── TaskService.java
        ├── model/
            └── Task.java
        ├── repository/
            └── TaskRepository.java
        ├── dto/
            ├── TaskRequestDTO.java
            └── TaskResponseDTO.java
        └── exception/
            ├── TaskNotFoundException.java
            ├── TaskDataInvalidException.java
            └── GlobalExceptionHandler.java

    └── main/resources/static/
        └── index.html
    └── main/resources/
        └── application.properties
```

##### 6. Run:
- Run the TodoApplication.java in IntelliJ

##### 7. Open your browser and go to:
      http://localhost:8080/index.html

#### Feacures:
- Add Task: Enter a title (required) and description (optional)
- View Tasks: Shows all tasks in a list
- Update Task: Edit title, description, or mark as completed
- Delete Task: Remove tasks from the list
- Validation: validate every process

- Add task: enter a title (required) and description (optional) to create a new task
- View tasks: see all tasks listed with their current status
- Update task: edit title, description, or mark a task as completed
- Delete task: remove tasks from the list
- Validation: validates fields and shows error messages if invalid

#### Screenshot:
