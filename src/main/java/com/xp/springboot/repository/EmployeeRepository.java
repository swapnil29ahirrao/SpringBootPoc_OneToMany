package com.xp.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xp.springboot.entities.Employee;

/**
 * Employee Repository interface extending JPARepository to get access to different ready-made
 * DB operations.
 * 
 * @author sahirrao
 *
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
