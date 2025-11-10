package com.example.emp_java_spring.service;
import com.example.emp_java_spring.exception.EmployeeServiceException;
import com.example.emp_java_spring.model.Employee;
import org.springframework.stereotype.Indexed;
import org.springframework.stereotype.Service;

import javax.print.attribute.standard.MediaSize;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private final Map<Integer,Employee> employeeMap;

    public EmployeeService(){

        employeeMap=new HashMap<>();
    }

    public List<Employee> getEmployees() {
        try{
           return new ArrayList<>(employeeMap.values());
        }
        catch(Exception ex){
            throw new EmployeeServiceException("Failed to fetch Employees" , ex);
        }
    }

    public void addEmployee(Employee employee)  {
        if(employeeMap.containsKey(employee.getId())){
            throw new EmployeeServiceException("Employee ID already exists!");
        }
        try{
            employeeMap.put(employee.getId() , employee);
        }
        catch(Exception ex){
            throw new EmployeeServiceException("Failed to add Employee" ,ex);
        }
    }

    public Employee getEmployeeById(int id){
        try{
            Employee employee= employeeMap.get(id);

            if(employee==null){
                throw new EmployeeServiceException("Employee not found with ID: " + id);
            }
            return employee;
        }
        catch (Exception ex){
            throw new EmployeeServiceException("Failed to fetch!" , ex);
        }
    }

    public void deleteEmployee(int id){
        if(!employeeMap.containsKey(id)){
            throw new EmployeeServiceException("EmployeeId not present!");
        }
        try{
            employeeMap.remove(id);
        }
        catch(Exception ex){
            throw new EmployeeServiceException("Failed to delete Employee!",ex);
        }
    }

    public void updateSalary(int id, double salary){
        if(!employeeMap.containsKey(id)){
            throw new EmployeeServiceException("EmployeeId not present so failed to update salary");
        }
        try{
            Employee employee= employeeMap.get(id);
            employee.setSalary(salary);
            employeeMap.put(id,employee);
        } catch (Exception ex) {
            throw new EmployeeServiceException("Failed to update salary",ex);
        }
    }

    public Map<String ,Double> getAverageSalaryPerDepartment(){
        if (employeeMap.isEmpty()) {
            throw new EmployeeServiceException("No employees found!");
        }
        try{
            return employeeMap.values().stream()
                    .collect(Collectors.groupingBy(
                            Employee::getDepartment,
                            Collectors.averagingDouble(Employee::getSalary)
                    ));
        }
        catch (Exception ex) {
            throw new EmployeeServiceException("Failed to calculate average salary per department", ex);
        }
    }

    public Employee getHighestPaidEmployee(){
        try{
            return employeeMap.values().stream()
                    .max(Comparator.comparingDouble(Employee::getSalary))
                    .orElseThrow(()->new EmployeeServiceException("No employees found!"));
        }
        catch (Exception ex){
            throw new EmployeeServiceException("Failed to calculate highest paid employee",ex);
        }
    }

    public List<Employee> getEmployeesEarningAboveAverage(){
        if (employeeMap.isEmpty()) {
            throw new EmployeeServiceException("No employees found!");
        }

        try{
            double averageSalary=employeeMap.values().stream()
                    .mapToDouble(Employee::getSalary)
                    .average()
                    .orElse(0.0);

            return employeeMap.values().stream()
                    .filter(employee -> employee.getSalary()>averageSalary)
                    .toList();
        }
        catch (Exception ex){
            throw new EmployeeServiceException("Failed to calculate employees earning above average");
        }
    }

}
