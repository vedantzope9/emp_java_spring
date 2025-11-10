package com.example.emp_java_spring.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    int id;
    String name;
    double salary;
    String department;
}
