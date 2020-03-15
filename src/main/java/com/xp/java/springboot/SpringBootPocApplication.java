package com.xp.java.springboot;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.xp.java.springboot.entities.Address;
import com.xp.java.springboot.entities.Employee;
import com.xp.java.springboot.repository.AddressRepository;
import com.xp.java.springboot.repository.EmployeeRepository;
import com.xp.java.springboot.services.EmployeeService;

@SpringBootApplication
public class SpringBootPocApplication{
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootPocApplication.class, args);
	}

}
