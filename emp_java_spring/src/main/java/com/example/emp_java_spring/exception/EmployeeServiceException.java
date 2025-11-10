package com.example.emp_java_spring.exception;

public class EmployeeServiceException extends RuntimeException{
    public EmployeeServiceException(String message, Throwable cause){
        super(message, cause);
    }

    public EmployeeServiceException(String message){
        super(message);
    }
}
