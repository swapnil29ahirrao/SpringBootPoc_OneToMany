package com.xp.java.springboot.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xp.java.springboot.entities.Address;
import com.xp.java.springboot.entities.Employee;
import com.xp.java.springboot.services.EmployeeService;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService empService;
	
	@GetMapping
	public ResponseEntity<List<Employee>> getAllEmployee(){
		return new ResponseEntity<List<Employee>>(empService.getAllEmployee(),HttpStatus.OK);
	}
	
	@GetMapping("/{emp_id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable("emp_id") int emp_id) throws Exception{
		Employee emp=empService.getEmployee(emp_id);
		return new ResponseEntity<Employee>(emp,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Employee> createOrUpdateEmployee(@RequestBody Employee employee){
		Employee emp=empService.createOrUpdateEmployee(employee);
		return new ResponseEntity<Employee>(emp,HttpStatus.OK);
	}
	
	@DeleteMapping("/{emp_id}")
	public HttpStatus deleteEmployee(@PathParam("emp_id") int empId) throws Exception {
		empService.deleteEmployee(empId);
		return HttpStatus.OK;
	}

}
