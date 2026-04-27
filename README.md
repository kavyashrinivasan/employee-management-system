# Employee Management System
## Project overview
Employee Management API is a backend application built using Java and Spring Boot for managing employee records.
It provides complete CRUD (Create, Read, Update, Delete) operations using REST APIs and stores data in PostgreSQL database.

This project demonstrates backend development practices such as:
RESTful API development
Database integration using Spring Data JPA
PostgreSQL connectivity
Maven project structure
API testing using Postman

## Tech Stack
-Java
-Spring Boot
-Spring Data JPA
-PostgreSQL
-Maven
-Lombok
-Postman

## Features
-Add new employee
-View all employees
-Update employee details
-Delete employee record
-PostgreSQL database integration
-REST API architecture

## API Endpoints
1. Get All Employees
GET /employees

3. Add Employee
POST /employees

Sample Request Body:
{ "name": "Kavya", "email": "kavya@gmail.com", "role": "Java Developer", "salary": 55000 }

3. Update Employee
PUT /employees/{id}
Example:
PUT /employees/1

4. Delete Employee
DELETE /employees/{id}
Example:
DELETE /employees/1

## How to Run
1. Clone repo
https://github.com/kavyashrinivasan/employee-management-system.git

3. Run server
IntelliJ IDEA
Eclipse
VS Code (optional)

5. Configure PostgreSQL
Update application.properties

spring.datasource.url=jdbc:postgresql://localhost:5432/your_database_name
spring.datasource.username=your_username
spring.datasource.password=your_password

6. Run the Spring Boot application
Run the main class:
EmployeeApplication.java

## Test APIs using Postman
Use:
http://localhost:8080/employees
for POST, GET, PUT, DELETE requests.

## Screenshots
### POST API Response
<img width="884" height="565" alt="image" src="https://github.com/user-attachments/assets/96c346c4-f985-4e07-9cbf-e22e54848363" />

### GET API Response
<img width="930" height="555" alt="image" src="https://github.com/user-attachments/assets/31c355e6-ad14-4a58-968c-cbfd059c6384" />

## Author
Kavya Srinivasan
Software Developer | Java Backend Developer
GitHub: https://github.com/yourusername
