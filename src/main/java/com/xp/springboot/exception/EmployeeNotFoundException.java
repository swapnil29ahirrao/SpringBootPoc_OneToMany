package com.xp.springboot.exception;

/**
 * Represents Custom Exception class when Employee is not found
 * 
 * @author Swapnil Ahirrao
 *
 */
public class EmployeeNotFoundException extends RuntimeException{
	
	public EmployeeNotFoundException(int empId) {
		super("Employee with Employee ID: " + empId+ " does not exist");
	}
}
