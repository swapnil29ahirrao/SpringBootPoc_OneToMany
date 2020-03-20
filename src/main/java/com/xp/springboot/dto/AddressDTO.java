package com.xp.springboot.dto;

import com.xp.springboot.entities.Employee;

public class AddressDTO {
	
	private String addressType;
	private String lane;
	private String state;
	private int pincode;
	private Employee emp;
	public AddressDTO() {
		super();
	}
	

	public AddressDTO(String addressType, String lane, String state, int pincode, Employee emp) {
		super();
		this.addressType = addressType;
		this.lane = lane;
		this.state = state;
		this.pincode = pincode;
		this.emp = emp;
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
		return "AddressDTO [addressType=" + addressType + ", lane=" + lane + ", state=" + state + ", pincode=" + pincode
				+ ", emp=" + emp + "]";
	}

}
