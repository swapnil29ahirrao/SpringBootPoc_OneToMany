package com.xp.springboot.controller;

import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xp.springboot.dto.EmployeeDTO;
import com.xp.springboot.entities.Employee;
import com.xp.springboot.services.EmployeeService;

/**
 * Represents Rest Controller for handling request coming to "/Employee" URL
 *
 */

@RestController
@RequestMapping("/Employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService empService;
	
	/**
	 * Method to return all the Employees present in DB
	 * 
	 * @return ResponseEntity<List<Employee>>
	 */
	@GetMapping
	public ResponseEntity<List<Employee>> getAllEmployee(){
		return new ResponseEntity<>(empService.getAllEmployee(),HttpStatus.OK);
	}
	
	/**
	 * Method to return specific employee matching passed employee ID
	 * 
	 * @param empId
	 * @return ResponseEntity<Employee>
	 */
	@GetMapping("/{emp_id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable("emp_id") int empId){
		Employee emp=empService.getEmployee(empId);
		return new ResponseEntity<>(emp,HttpStatus.OK);
	}
	
	/**
	 * Method to create a Employee in DB if does not exist or update if already exists.
	 * Accessible only to user with Role as Admin.
	 * 
	 * @param employee
	 * @return ResponseEntity<Employee>
	 * 
	 */
	@PostMapping
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<Employee> createOrUpdateEmployee(@RequestBody EmployeeDTO employee){
		Employee employee1=new DozerBeanMapper().map(employee, Employee.class);
		Employee emp=empService.createOrUpdateEmployee(employee1);
		return new ResponseEntity<>(emp,HttpStatus.OK);
	}
	
	/**
	 * Method to delete a employee from DB if provided employee id exists.
	 * Accessible only to user with Role as Admin.
	 * 
	 * @param empId
	 * @return
	 */
	
	@DeleteMapping("/{emp_id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public HttpStatus deleteEmployee(@PathVariable("emp_id") int empId){
		empService.deleteEmployee(empId);
		return HttpStatus.OK;
	}

}
