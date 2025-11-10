# Employee Salary Processor API

A **Spring Boot REST API** for managing employees and processing salary-related analytics such as:
- Average salary per department
- Highest paid employee
- Employees earning above average  


## Features

**CRUD Operations**
- Add new employees  
- Retrieve an employee by ID  
- List all employees  
- Delete employees  
- Update salary by ID  

**Analytical Operations**
- Calculate **average salary per department**  
- Find the **highest paid employee**  
- List all employees earning **above the average salary**

**Exception Handling**
- Graceful custom exceptions for missing or duplicate employee IDs  
- Clear and descriptive error messages for each operation

---

## Architecture Overview

The project follows the **Spring Boot layered architecture**:

Controller → Service → Model


### 1. Controller Layer
Handles incoming HTTP requests and maps them to service operations.

### 2. Service Layer
Contains business logic such as:
- Salary computation
- Data validation
- Stream-based aggregation

### 3. Model Layer
Defines the **Employee** entity:
```java
private int id;
private String name;
private double salary;
private String department;
```
## 🧩 Endpoints Summary

| **Method** | **Endpoint** | **Description** |
|:-----------:|:-------------|:----------------|
| `POST` | `/employee/` | Add a new employee |
| `GET` | `/employee/{id}` | Get employee by ID |
| `GET` | `/employee/all` | List all employees |
| `DELETE` | `/employee/{id}` | Delete employee by ID |
| `PUT` | `/employee/update-salary?id=1&salary=50000` | Update salary by ID |
| `GET` | `/employee/average-salary` | Get average salary per department |
| `GET` | `/employee/highest-salary` | Get the highest paid employee |
| `GET` | `/employee/above-average` | Get employees earning above average |



### Why Map<Integer,Employee> over List<Employee> ?

Using a Map is ideal because employee ID is unique, and most operations (get, update, delete) depend on that ID.
This design makes the API faster, cleaner, and more efficient for ID-based lookups.

Thank you....
