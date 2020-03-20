package com.xp.springboot.dto;

import java.util.ArrayList;
import java.util.List;

import org.dozer.Mapping;

import com.xp.springboot.entities.Address;

public class EmployeeDTO {
	
	private String empName;
	private int empSalary;
	private int age;
	List<Address> addList=new ArrayList<>();
	
	public EmployeeDTO() {
		super();
	}
	
	public EmployeeDTO(String empName, int empSalary, int age, List<Address> addList) {
		super();
		this.empName = empName;
		this.empSalary = empSalary;
		this.age = age;
		this.addList = addList;
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
	public List<Address> getAddList() {
		return addList;
	}
	public void setAddList(List<Address> addList) {
		this.addList = addList;
	}

	@Override
	public String toString() {
		return "EmployeeDTO [empName=" + empName + ", empSalary=" + empSalary + ", age=" + age + ", addList=" + addList
				+ "]";
	}
	

}
