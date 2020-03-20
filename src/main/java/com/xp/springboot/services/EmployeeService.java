package com.xp.springboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xp.springboot.entities.Employee;
import com.xp.springboot.exception.EmployeeNotFoundException;
import com.xp.springboot.repository.EmployeeRepository;

/**
 * Represents Employee service layer to interact with Employee Repository and provide 
 * services to Employee Controller.
 * 
 * @author Swapnil Ahirrao
 *
 */
@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository empRepository;
	
	/**
	 * Method to get all the employee present in DB
	 * 
	 * @return List<Employee>
	 */
	public List<Employee> getAllEmployee(){
		return empRepository.findAll();
	}
	
	/**
	 * Method to return employee with passed employee id
	 * 
	 * @param empId
	 * @return Employee
	 */
	public Employee getEmployee(int empId) {
		Optional<Employee> emp=empRepository.findById(empId);
		if(emp.isPresent()) 
			return emp.get();
		else
			throw new EmployeeNotFoundException(empId);
	}
	
	/**
	 * Method to create or update employee if already exists with provided employee object
	 * 
	 * @param employee
	 * @return Employee
	 */
	public Employee createOrUpdateEmployee(Employee employee) {
		Optional<Employee> emp=empRepository.findById(employee.getEmpId());
		if(emp.isPresent()) {
			Employee empEntity=emp.get();
			empEntity.setAge(employee.getAge());
			empEntity.setEmpName(employee.getEmpName());
			empEntity.setEmpSalary(employee.getEmpSalary());
			
			empEntity=empRepository.save(empEntity);
			return empEntity;
		}else
		{
			employee=empRepository.save(employee);
			return employee;
		}
	}
	
	/**
	 * Method to delete employee from database if already exists
	 * 
	 * @param empId
	 * @return Boolean
	 */
	public boolean deleteEmployee(int empId) {
		Optional<Employee> emp=empRepository.findById(empId);
		
		if(emp.isPresent()) {
			empRepository.deleteById(empId);
		}
		else {
			throw new EmployeeNotFoundException(empId);
		}
		return true;
	}

}
