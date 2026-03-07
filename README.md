### To do list web
The to-do list is a web application built with Spring Boot that allows users to create, read, update, delete tasks

It includes a simple frontend with HTML, CSS, JS, and a backend built with Spring Boot, Spring data JPA, and H2 database

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
- Run the TodoApplication.java in the IntelliJ

##### 7. Open your browser and go to:
      http://localhost:8080/index.html

#### Feacures:
##### Frontend:
- Add task: enter a title (required) and description (optional) to create a new task
- View tasks: see all tasks listed with their current status
- Update task: edit title, description, or mark a task as completed
- Delete task: remove tasks from the list
- Validation (client-side): validates fields and shows error messages if invalid

##### Backend:
- Task management APIs: provides endpoints for create, read, update, delete operations
- Error handling: friendly error responses
- Data persistence: tasks stored in H2 in-memory database while the application is running
- Business logic: handles all task-related logic, like marking completed, updating details, and verifying existence
- Validation (server-side): validates fields and shows error messages if invalid

#### Screenshot:
