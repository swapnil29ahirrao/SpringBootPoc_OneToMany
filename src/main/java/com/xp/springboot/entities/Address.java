package com.xp.springboot.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * Entity Class representing Address
 * 
 * @author Swapnil Ahirrao
 *
 */
@Entity
@Table(name="Address")
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int addId;
	
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
	}

	public Address(int addId, String addressType, String lane, String state, int pincode, Employee emp) {
		super();
		this.addId = addId;
		this.addressType = addressType;
		this.lane = lane;
		this.state = state;
		this.pincode = pincode;
		this.emp = emp;
	}

	public int getAddId() {
		return addId;
	}

	public void setAddId(int addId) {
		this.addId = addId;
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

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	@Override
	public String toString() {
		return "Address [addId=" + addId + ", addressType=" + addressType + ", lane=" + lane + ", state=" + state
				+ ", pincode=" + pincode + ", emp=" + emp + "]";
	}
	
	
	
}
