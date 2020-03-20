package com.xp.springboot.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doThrow;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.xp.springboot.entities.Address;
import com.xp.springboot.entities.Employee;
import com.xp.springboot.exception.EmployeeNotFoundException;
import com.xp.springboot.repository.EmployeeRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class EmployeeServiceTest {

	@Autowired
	EmployeeService empService;
	
	@MockBean
	EmployeeRepository empRepo;
	
	@Test
	void testGetEmployee() {
		boolean exceptionThrown=false;
		List<Address> addList=new ArrayList<>();
		Address add1=new Address();
		add1.setAddId(1);
		add1.setAddressType("Home");
		add1.setLane("1");
		add1.setPincode(411015);
		add1.setState("MH");
		addList.add(add1);
		
		Employee emp=new Employee();
		emp.setEmpName("Swap");
		emp.setEmpId(1);
		emp.setEmpSalary(10000);
		emp.setAge(20);
		add1.setEmp(emp);
		emp.setAddList(addList);
		Optional<Employee> employee=Optional.ofNullable(emp);
		Optional<Employee> empNull=Optional.ofNullable(null);
		
		Mockito.when(empRepo.findById(2)).thenReturn(empNull);		
		doThrow(EmployeeNotFoundException.class).when(empRepo).findById(2);
		try {
			empService.getEmployee(2);
		}catch (EmployeeNotFoundException e) {
			exceptionThrown=true;
		}
		assertTrue(exceptionThrown);
		
		Mockito.when(empRepo.findById(emp.getEmpId())).thenReturn(employee);
		assertThat(empService.getEmployee(emp.getEmpId())).isEqualTo(emp);
	}
	
	@Test
	void testGetAllEmployee() {
		List<Address> addList=new ArrayList<>();
		Address add1=new Address();
		add1.setAddId(1);
		add1.setAddressType("Home");
		add1.setLane("1");
		add1.setPincode(411015);
		add1.setState("MH");
		addList.add(add1);
		
		Employee emp=new Employee();
		emp.setEmpName("Swap");
		emp.setEmpId(1);
		emp.setEmpSalary(10000);
		emp.setAge(20);
		add1.setEmp(emp);
		emp.setAddList(addList);
		List<Employee> empList=new ArrayList<>();
		empList.add(emp);
		
		Mockito.when(empRepo.findAll()).thenReturn(empList);
		assertThat(empService.getAllEmployee()).isEqualTo(empList);
	}
	
	@Test
	void testCreateOrUpdateEmployee() {
		List<Address> addList=new ArrayList<>();
		Address add1=new Address();
		add1.setAddId(1);
		add1.setAddressType("Home");
		add1.setLane("1");
		add1.setPincode(411015);
		add1.setState("MH");
		addList.add(add1);
		
		Employee emp=new Employee();
		emp.setEmpName("Swap");
		emp.setEmpId(1);
		emp.setEmpSalary(10000);
		emp.setAge(20);
		add1.setEmp(emp);
		emp.setAddList(addList);
		Optional<Employee> empNull=Optional.ofNullable(null);
		
		Mockito.when(empRepo.findById(emp.getEmpId())).thenReturn(empNull);
		Mockito.when(empRepo.save(emp)).thenReturn(emp);
		assertThat(empService.createOrUpdateEmployee(emp)).isEqualTo(emp);
		
		Optional<Employee> empOptional=Optional.ofNullable(emp);
		Mockito.when(empRepo.findById(emp.getEmpId())).thenReturn(empOptional);
		emp.setAge(30);
		Mockito.when(empRepo.save(emp)).thenReturn(emp);
		assertThat(empService.createOrUpdateEmployee(emp)).isEqualTo(emp);
	}
	
	@Test
	void testDeleteEmployee() {
		boolean exceptionThrown=false;
		List<Address> addList=new ArrayList<>();
		Address add1=new Address();
		add1.setAddId(1);
		add1.setAddressType("Home");
		add1.setLane("1");
		add1.setPincode(411015);
		add1.setState("MH");
		addList.add(add1);
		
		Employee emp=new Employee();
		emp.setEmpName("Swap");
		emp.setEmpId(1);
		emp.setEmpSalary(10000);
		emp.setAge(20);
		add1.setEmp(emp);
		emp.setAddList(addList);
		Optional<Employee> employee=Optional.ofNullable(emp);
		Optional<Employee> empNull=Optional.ofNullable(null);
		
		Mockito.when(empRepo.findById(2)).thenReturn(empNull);		
		doThrow(EmployeeNotFoundException.class).when(empRepo).deleteById(2);
		try {
			empService.deleteEmployee(2);
		}catch (EmployeeNotFoundException e) {
			exceptionThrown=true;
		}
		assertTrue(exceptionThrown);
		
		Mockito.when(empRepo.findById(emp.getEmpId())).thenReturn(employee);
		Mockito.doNothing().when(empRepo).deleteById(emp.getEmpId());
		assertThat(empService.deleteEmployee(emp.getEmpId())).isEqualTo(true);
		
	}
}
