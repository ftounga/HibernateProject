package com.masterheboss.service;

import java.util.List;

import com.masterheboss.repository.EmployeeRepository;
import com.mastertheboss.entity.Department;
import com.mastertheboss.entity.Employee;

public class EmployeeService {

	private EmployeeRepository employeeRepository = new EmployeeRepository(Department.class);
	
	public Employee findSpecificEmployee(Long id){
		return employeeRepository.findOne(id);
	}
	
	public List<Employee> findAllEmployee(){
		return employeeRepository.findAll();
	}
}
