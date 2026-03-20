### To do list web
The to-do list is a simple Spring Boot web application built using domain driven design principles, it allows users to efficiently create, read, update, and delete tasks

#### Steps:
##### 1. Go to Spring initializr:
      https://start.spring.io
      
##### 2. Create a new project with these settings:
- Project: Maven
- Language: `Java`
- Spring Boot: 4.0.3
- Project metadata: group: `com.example`, artifact: `todo`, Java version: 17
- Dependencies: add `Spring web`, `Spring data JPA`, `H2 database`

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
        ├── controller/
            └── TaskController.java              // Handles HTTP API endpoints, interacts with the service
        ├── service/
            └── TaskService.java                 // Contains business logic and orchestrates domain actions
        ├── repository/
            └── TaskRepository.java              // Interfaces with the H2 DB
        ├── domain/
            └── Task.java                        // Core domain entity representing a task with all business rules
        ├── dto/
            ├── TaskRequestDTO.java              // DTO for incoming requests
            └── TaskResponseDTO.java             // DTO for outgoing responses
        └── exception/
            ├── TaskNotFoundException.java      
            ├── TaskDataInvalidException.java   
            └── GlobalExceptionHandler.java      
        ├── TodoApplication.java             

    └── main/resources/static/
        └── index.html                        
    └── main/resources/
        └── application.properties                  
```

##### 6. Run:
- Run the `TodoApplication.java` class

##### 7. Open your browser and go to:
      http://localhost:8080/index.html

#### Domain driven design principles:
The domain driven design - DDD is a software design approach that focuses on organizing the code around the core business logic rather than technical details

##### In this project:
- The **domain entity** is represented by `Task.java` class, which contains all business rules and input data validations
- The **service layer** is represented by `TaskService.java` class, which manages how tasks are created, updated, retrieved, and deleted by coordinating between the domain and the repository
- The **controller layer** is represented by `TaskController.java`, handles `HTTP` requests and delegates all logic to the service layer
- The **repository layer** is represented by `TaskRepository.java`, only for database operations
- The **data transfer objects - DTO** is represented by `TaskRequestDTO.java` and `TaskResponseDTO.java`, are used to transfer data between the client and the server, keeping the domain entity independent from external input and output
- The **custom exceptions** is represented by `TaskNotFoundException` and `TaskDataInvalidException`, are used to handle errors clearly, and `GlobalExceptionHandler` ensures proper `HTTP` responses

##### This structure ensures:
- Clear separation of concerns
- Centralized and consistent business logic
- Better error handling
- Easier maintenance and scalability

#### Features:
##### Frontend:
- Add task: enter a title (required), description (optional), due date (optional) to create a new task
- View tasks: displays all tasks with their data
- Update task: user can edit title, description, due date, or mark a task as completed
- Delete task: tasks can be removed from the list
- Overdue tasks: tasks past their due date are automatically highlighted in red
- Completed tasks: tasks marked as completed are highlighted in green and the title is crossed out
- Client-side validation: prevents invalid inputs before sending data to the backend

##### Backend:
- REST API endpoints: provides endpoints for CRUD operations, all endpoints return `JSON` responses and use proper `HTTP` status codes
- Error handling: returns clear and descriptive error messages
- Data storage: tasks are stored in `H2` in-memory database while the application is running
- Business logic and domain driven design: the `Task.java` contains all business rules and validations, and the `TaskService.java` manages how tasks are created, updated, retrieved, and deleted by coordinating calls to the domain entity and the repository
- Server-side validation: ensures all tasks have valid data
  
#### Usage:
- Through web interface or Postman to call API directly

#### API endpoints:
You can interact with the API using `HTTP` requests, and the base URL is:
```
http://localhost:8080/tasks
```

##### Get all tasks:
- Method: `GET`
- URL: `/tasks`
- Description: fetch all tasks
- Response example:
```
[
  {
    "id": 1,
    "title": "Read book",
    "description": "Finish chapter 5",
    "dueDate": "2026-03-20",
    "completed": false
  },
  {
    "id": 2,
    "title": "Homework",
    "description": "Math exercises page 30",
    "dueDate": null,
    "completed": true
  }
]
```
- Errors: returns 500 internal server error if server fails

##### Get task by ID:
- Method: `GET`
- URL: `/tasks/{id}`
- Description: fetch a single task by its ID
- Response example:
```
{
  "id": 1,
  "title": "Read book",
  "description": "Finish chapter 5",
  "dueDate": "2026-03-20",
  "completed": false
}
```
- Errors: returns 404 not found if task ID does not exist, returns 500 internal server error for server issues

##### Create a task:
- Method: `POST`
- URL: `/tasks`
- Description: create a new task
- Request example:
```
{
  "title": "Read book",
  "description": "Finish chapter 5",
  "dueDate": "2026-03-20",
  "completed": false
}
```
- Response: returns 201 created with the created task
- Errors: returns 400 bad request if title missing, title < 3 or title > 100 chars, description > 200 chars, due date in the past, returns 500 internal server error for unexpected errors

##### Update a task:
- Method: `PUT`
- URL: `/tasks/{id}`
- Description: update an existing tasks title, description, due date, or completed status
- Request example:
```
{
  "title": "Read book",
  "description": "Finish chapter 6 instead of chapter 5",
  "dueDate": "2026-03-25",
  "completed": true
}
```
- Response: returns updated task
- Errors: returns 404 not found if task does not exist, returns 400 bad request if input violates domain rules, returns 500 internal server error for server errors

##### Delete a task:
- Method: `DELETE`
- URL: `/tasks/{id}`
- Description: delete a task by ID
- Response: returns 204 no content if task was successfully deleted, this means the request succeeded, but the server does not return anything in the response body
- Errors: returns 404 not found if task does not exist

#### Screenshot:
![1](https://raw.githubusercontent.com/HananMurrar/ToDoListWeb/main/todo/result.png)
