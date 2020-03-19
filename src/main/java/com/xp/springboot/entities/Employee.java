package com.xp.springboot.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="Employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int emp_id;
	private String emp_name;
	private int emp_salary;
	private int age;
	
	@OneToMany(mappedBy = "emp",cascade = CascadeType.ALL)
	@JsonManagedReference
	List<Address> addList=new ArrayList<Address>();
	
	
	public List<Address> getAddList() {
		return addList;
	}


	public void setAddList(List<Address> addList) {
		this.addList = addList;
	}


	public Employee(int emp_id, String emp_name, int emp_salary, int age, List<Address> addList) {
		super();
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.emp_salary = emp_salary;
		this.age = age;
		this.addList = addList;
	}


	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public int getEmp_salary() {
		return emp_salary;
	}
	public void setEmp_salary(int emp_salary) {
		this.emp_salary = emp_salary;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", emp_name=" + emp_name + ", emp_salary=" + emp_salary + ", age=" + age
				+ "]";
	}
	
}
