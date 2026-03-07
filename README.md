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
- Add task: enter a title (required) and description (optional) to create a new task
- View tasks: see all tasks listed with their current status
- Update task: edit title, description, or mark a task as completed
- Delete task: remove tasks from the list
- Client-side validation: prevents invalid inputs before sending them to the server

##### Backend:
- Task management APIs: provides endpoints for create, read, update, delete operations
- Error handling: friendly error responses
- Data persistence: tasks stored in H2 in-memory database while the application is running
- Business logic: handles task updates, completion status, data validation
- Data storage: tasks are stored in H2 in-memory database
- Server-side validation: ensures tasks have valid data

#### Usage:
- Using the web interface or using Postman for API testing

#### API usage examples:
You can interact with API using GET, POST, PUT, DELETE requests, the backend API for managing tasks is available at:
```
http://localhost:8080/tasks
```

##### Get all tasks:
- Method: GET
- URL: /tasks
- Description: fetch all tasks stored in the system
- Response example:
```
[
  {
    "id": 1,
    "title": "read book",
    "description": "finish chapter 5",
    "completed": false
  },
  {
    "id": 2,
    "title": "do homework",
    "description": "math exercises page 30",
    "completed": true
  }
]
```

##### Get task by ID:
- Method: GET
- URL: /tasks/{id}
- Description: fetch a single task by its ID
- Response example:
```
{
  "id": 1,
  "title": "read book",
  "description": "finish chapter 5",
  "completed": false
}
```
- Errors: returns 404 not found if the task does not exist

##### Create a task:
- Method: POST
- URL: /tasks
- Description: create a new task
- Request body example:
```
{
  "title": "read book",
  "description": "finish chapter 5",
  "completed": false
}
```
- Response: returns the created task with ID
- Errors: returns 400 bad request if the title is missing

##### Update a task:
- Method: PUT
- URL: /tasks/{id}
- Description: update an existing task’s title, description, or completed status
- Request body example:
```
{
  "title": "read book",
  "description": "finish chapter 6 instead of chapter 5",
  "completed": true
}
```
- Response: returns the updated task
- Errors: returns 404 not found if the task does not exist, returns 400 bad request if the title is empty

##### Delete a task:
- Method: DELETE
- URL: /tasks/{id}
- Description: delete a task by ID
- Response: returns 200 ok with a confirmation message
- Errors: returns 404 not found if the task does not exist

#### Screenshot:
![1](https://raw.githubusercontent.com/HananMurrar/ToDoListWeb/main/todo/result.png)

