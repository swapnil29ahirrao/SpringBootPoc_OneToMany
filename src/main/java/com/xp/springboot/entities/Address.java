package com.xp.springboot.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="Address")
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int add_Id;
	
	private String addressType;
	private String lane;
	private String state;
	private int pincode;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="emp_id")
	@JsonBackReference
	private Employee emp;
	
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(int add_Id, String addressType, String lane, String state, int pincode, Employee emp) {
		super();
		this.add_Id = add_Id;
		this.addressType = addressType;
		this.lane = lane;
		this.state = state;
		this.pincode = pincode;
		this.emp = emp;
	}



	public Employee getEmp() {
		return emp;
	}



	public void setEmp(Employee emp) {
		this.emp = emp;
	}



	public int getAdd_Id() {
		return add_Id;
	}

	public void setAdd_Id(int add_Id) {
		this.add_Id = add_Id;
	}

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	public String getLane() {
		return lane;
	}

	public void setLane(String lane) {
		this.lane = lane;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "Address [add_Id=" + add_Id + ", addressType=" + addressType + ", lane=" + lane + ", state=" + state
				+ ", pincode=" + pincode + "]";
	}

	
	
	
}
