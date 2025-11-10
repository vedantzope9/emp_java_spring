package com.example.emp_java_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmpJavaSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpJavaSpringApplication.class, args);
	}

}

/*
Employee Salary Processor API

Requirements:
Create a Spring Boot REST API with:
Employee class → id, name, salary, department.
Add a Service layer that performs logical operations:
Calculate average salary per department.
Find highest paid employee.
List employees earning above average.
Use in-memory data (List) (no DB needed for simplicity).
Expose endpoints:
POST /employee/ - create Employee
GET /employee/{id}
GET /employee/all → list all
DELETE /employee/{id}
PUT /employee/update-salary?id=1 (RequestParam)
GET /employee/average-salary (avg per department)
GET /employee/highest-salary
GET /employee/above-average
*/