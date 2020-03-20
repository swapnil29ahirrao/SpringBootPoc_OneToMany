package com.xp.springboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xp.springboot.entities.Employee;
import com.xp.springboot.exception.EmployeeNotFoundException;
import com.xp.springboot.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository empRepository;
	
	public List<Employee> getAllEmployee(){
		return empRepository.findAll();
	}
	
	public Employee getEmployee(int empId) {
		Optional<Employee> emp=empRepository.findById(empId);
		if(emp.isPresent()) 
			return emp.get();
		else
			throw new EmployeeNotFoundException(empId);
	}
	
	public Employee createOrUpdateEmployee(Employee employee) {
		Optional<Employee> emp=empRepository.findById(employee.getEmp_id());
		if(emp.isPresent()) {
			Employee empEntity=emp.get();
			empEntity.setAge(employee.getAge());
			empEntity.setEmp_name(employee.getEmp_name());
			empEntity.setEmp_salary(employee.getEmp_salary());
			
			empEntity=empRepository.save(empEntity);
			return empEntity;
		}else
		{
			employee=empRepository.save(employee);
			return employee;
		}
	}
	
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
