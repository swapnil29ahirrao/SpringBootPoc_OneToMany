package com.xp.springboot.exception;

public class EmployeeNotFoundException extends RuntimeException{
	
	public EmployeeNotFoundException(int empId) {
		super("Employee with Employee ID: " + empId+ " does not exist");
	}
}
