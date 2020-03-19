package com.xp.springboot;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.xp.springboot.entities.Address;
import com.xp.springboot.entities.Employee;
import com.xp.springboot.repository.EmployeeRepository;
import com.xp.springboot.services.EmployeeService;

@SpringBootApplication
public class SpringBootPocApplication{
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootPocApplication.class, args);
	}

}
