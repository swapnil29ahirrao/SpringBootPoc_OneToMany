package com.xp.java.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xp.java.springboot.entities.Address;
import com.xp.java.springboot.entities.Employee;

public interface AddressRepository extends JpaRepository<Address, Integer>{

}
