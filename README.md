### To do list web
The to-do list is a simple web application built with Spring Boot that allows users to create, read, update, delete tasks

It includes a simple frontend with HTML, CSS, JS, and a backend built with Spring Boot, Spring data JPA, H2 database

#### Steps:
##### 1. Go to Spring initializr:
      https://start.spring.io
      
##### 2. Create a new project with these settings:
- Project: Maven
- Language: Java
- Spring Boot: 4.0.3
- Project metadata: group: com.example, artifact: todo, Java version: 17
- Dependencies: add Spring web, Spring data JPA, H2 database

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
            └── TaskController.java        // Handles API endpoints
        ├── service/
            └── TaskService.java           // Contains business logic
        ├── repository/
            └── TaskRepository.java        // Interacts with H2 database
        ├── model/
            └── Task.java                  // Entity representing a task
        ├── dto/
            ├── TaskRequestDTO.java        // DTO for incoming requests
            └── TaskResponseDTO.java       // DTO for outgoing responses
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

#### Features:
##### Frontend:
- Add task: enter a title (required) and description (optional), due date (optional) to create a new task
- View tasks: see all tasks listed with their current status
- Update task: edit title, description, due date, or mark a task as completed
- Delete task: remove tasks from the list
- Overdue tasks: tasks past their due date are highlighted in red
- Client-side validation: prevents invalid inputs before sending them to the server

##### Backend:
- REST API endpoints: provides endpoints for CRUD operations, all endpoints return JSON responses and use proper HTTP status code
- Error handling: returns clear and descriptive error messages with appropriate HTTP status codes
- Data storage: tasks stored in H2 in-memory database
- Business logic: validates data and manages task state
- Server-side validation: ensures all tasks have valid data

#### Usage:
- Through web interface or Postman to call API directly

#### API endpoints:
You can interact with API using GET, POST, PUT, DELETE requests, and the base URL:
```
http://localhost:8080/tasks
```

##### Get all tasks:
- Method: GET
- URL: `/tasks`
- Description: fetch all tasks
- Response example:
```
[
  {
    "id": 1,
    "title": "Read book",
    "description": "Finish chapter 5",
    "dueDate": "20/03/2026",
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
- Method: GET
- URL: `/tasks/{id}`
- Description: fetch a single task by its ID
- Response example:
```
{
  "id": 1,
  "title": "Read book",
  "description": "Finish chapter 5",
  "dueDate": "20/03/2026",
  "completed": false
}
```
- Errors: returns 404 not found if task ID does not exist, 500 internal server error for server issues

##### Create a task:
- Method: POST
- URL: `/tasks`
- Description: create a new task
- Request example:
```
{
  "title": "Read book",
  "description": "Finish chapter 5",
  "dueDate": "20/03/2026",
  "completed": false
}
```
- Response: returns created task with ID
- Errors: returns 400 bad request if title missing, title < 3 or > 100 chars, description > 200 chars, return 500 internal server error for unexpected errors

##### Update a task:
- Method: PUT
- URL: `/tasks/{id}`
- Description: update an existing tasks title, description, or completed status
- Request example:
```
{
  "title": "Read book",
  "description": "Finish chapter 6 instead of chapter 5",
  "dueDate": "25/03/2026",
  "completed": true
}
```
- Response: returns updated task
- Errors: returns 404 not found if task does not exist, 400 bad request if title invalid, 500 internal server error for server errors

##### Delete a task:
- Method: DELETE
- URL: `/tasks/{id}`
- Description: delete a task by ID
- Response: returns 200 ok with a confirmation message
- Errors: returns 404 not found if the task does not exist
- Response: returns 204 no content if task was successfully deleted, this means the request succeeded, but the server does not return any JSON or message in the response body
- Errors: returns 404 not found if task does not exist

#### Screenshot:
![1](https://raw.githubusercontent.com/HananMurrar/ToDoListWeb/main/todo/result.png)
