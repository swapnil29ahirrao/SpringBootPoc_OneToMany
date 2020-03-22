package com.xp.springboot.utilities;

import org.dozer.DozerBeanMapper;

import com.xp.springboot.dto.EmployeeDTO;
import com.xp.springboot.entities.Employee;

public class ConversionUtility {
	
	static DozerBeanMapper dozerBeanMapper=new DozerBeanMapper();
	
	private ConversionUtility() {
		super();
	}

	public static Employee employeeDtoToEntity(EmployeeDTO empDTO) {
		Employee emp=dozerBeanMapper.map(empDTO, Employee.class);
		for(int i=0;i<empDTO.getAddList().size();i++) {
			emp.getAddList().get(i).setEmp(emp);
		}
		return emp;
	}
}
