Database used -mysql

technology used-java springboot(frontend files are in src/main/rsources folder)
# Task Management API Reference

## Login API:
- **Request Type:** POST
- **Endpoint:** localhost:8080/login
- **Payload:**
  ```json
  {
      "email": "pratiksha.doe@example.com",
      "password": "Pratiksha@11"
  }

APIs for Tasks:
Register New Task
Request Type: POST
Endpoint: localhost:8080/addtask
Payload:
{
  "description": "Implement user authentication module",
  "assignedDateTime": "2024-05-11T10:00:00",
  "expectedCompletionDateTime": "2024-05-15T18:00:00",
  "assigner": 1,
  "assignee": 2
}

Get List of All Tasks

Request Type: GET
Endpoint: localhost:8080/tasks
Get Task by ID

Request Type: GET
Endpoint: localhost:8080/gettask/{id}
Delete Task by ID

Request Type: DELETE
Endpoint: localhost:8080/deletetask/4
Update Task by ID

Request Type: PUT
Endpoint: localhost:8080/updatetask/{id}
Payload:
{
  "description": "Implement user authentication module",
  "assignedDateTime": "2024-05-11T10:00:00",
  "expectedCompletionDateTime": "2024-05-15T18:00:00",
  "assigner": 1,
  "assignee": 2
}

APIs for Users:

Register User
Request Type: POST
Endpoint: localhost:8080/addUser
Payload:
json:
{
  "name": "Pratiksha Doe",
  "mobileNumber": "7667883211",
  "gender": "Female",
  "role": "User",
  "email": "pratiksha.doe@example.com",
  "password": "Pratiksha@11"
}

Get List of Users

Request Type: GET
Endpoint: localhost:8080/users
Get User by ID

Request Type: GET
Endpoint: localhost:8080/user/{id}
