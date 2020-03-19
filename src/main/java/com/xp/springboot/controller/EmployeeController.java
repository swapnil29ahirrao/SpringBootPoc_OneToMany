package com.xp.springboot.controller;

import java.util.List;

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

import com.xp.springboot.entities.Employee;
import com.xp.springboot.services.EmployeeService;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService empService;
	
	@GetMapping
	public ResponseEntity<List<Employee>> getAllEmployee(){
		return new ResponseEntity<>(empService.getAllEmployee(),HttpStatus.OK);
	}
	
	@GetMapping("/{emp_id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable("emp_id") int empId){
		Employee emp=empService.getEmployee(empId);
		return new ResponseEntity<>(emp,HttpStatus.OK);
	}
	
	@PostMapping
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<Employee> createOrUpdateEmployee(@RequestBody Employee employee){
		Employee emp=empService.createOrUpdateEmployee(employee);
		return new ResponseEntity<>(emp,HttpStatus.OK);
	}
	
	@DeleteMapping("/{emp_id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public HttpStatus deleteEmployee(@PathVariable("emp_id") int empId){
		empService.deleteEmployee(empId);
		return HttpStatus.OK;
	}

}
