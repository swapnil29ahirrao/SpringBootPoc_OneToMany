package com.xp.java.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xp.java.springboot.entities.Address;
import com.xp.java.springboot.repository.AddressRepository;
import com.xp.java.springboot.repository.EmployeeRepository;

@RestController
@RequestMapping("/address")
public class AddressController {
	@Autowired
	AddressRepository addRepo;
	
	@Autowired
	EmployeeRepository empRepo;
	
	@PostMapping
	public Address createAddress(@RequestBody Address address) {
		return addRepo.save(address);
	}
}
