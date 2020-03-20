package com.xp.springboot.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * Entity Class representing Employee
 * 
 * @author Swapnil Ahirrao
 *
 */
@Entity
@Table(name="Employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empId;
	private String empName;
	private int empSalary;
	private int age;
	
	@OneToMany(mappedBy = "emp",cascade = CascadeType.ALL)
	@JsonManagedReference
	List<Address> addList=new ArrayList<>();
	
	
	public List<Address> getAddList() {
		return addList;
	}


	public void setAddList(List<Address> addList) {
		this.addList = addList;
	}


	public Employee(int empId, String empName, int empSalary, int age, List<Address> addList) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empSalary = empSalary;
		this.age = age;
		this.addList = addList;
	}


	public Employee() {
		super();
	}


	public int getEmpId() {
		return empId;
	}


	public void setEmpId(int empId) {
		this.empId = empId;
	}


	public String getEmpName() {
		return empName;
	}


	public void setEmpName(String empName) {
		this.empName = empName;
	}


	public int getEmpSalary() {
		return empSalary;
	}


	public void setEmpSalary(int empSalary) {
		this.empSalary = empSalary;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}
	
	
	
}
