package com.example.emp_java_spring.controller;

import ch.qos.logback.core.model.conditional.ElseModel;
import com.example.emp_java_spring.model.Employee;
import com.example.emp_java_spring.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    ResponseEntity<List<Employee>> getEmployees() {
        return ResponseEntity.ok(employeeService.getEmployees());
    }

    @PostMapping("/")
    ResponseEntity<String> addEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body("Employee added successfully!");
    }

    @GetMapping("/{id}")
    ResponseEntity<Employee> getEmployeeById(@PathVariable int id){
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<String> deleteEmployee(@PathVariable int id){
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok("Employee deleted successfully!");
    }

    @PutMapping("/update-salary")
    ResponseEntity<String> updateSalary(@RequestParam int id, @RequestParam double salary){
        employeeService.updateSalary(id,salary);
        return ResponseEntity.ok("Employee's salary updated successfully!");
    }

    @GetMapping("/average-salary")
    ResponseEntity<Map<String,Double>> getAverageSalaryPerDepartment(){
        return ResponseEntity.ok(employeeService.getAverageSalaryPerDepartment());
    }

    @GetMapping("/highest-salary")
    ResponseEntity<Employee> getHighestPaidEmployee(){
        return ResponseEntity.ok(employeeService.getHighestPaidEmployee());
    }

    @GetMapping("/above-average")
    ResponseEntity<List<Employee>> getEmployeesEarningAboveAverage(){
        return ResponseEntity.ok(employeeService.getEmployeesEarningAboveAverage());
    }
}
