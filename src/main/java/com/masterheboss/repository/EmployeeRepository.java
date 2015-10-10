package com.masterheboss.repository;

import com.mastertheboss.entity.Employee;

public class EmployeeRepository extends GenericRepository<Employee,Long> {

	public EmployeeRepository(Class entityClass) {
		super(entityClass);
	}
	
	public EmployeeRepository() {
		super(Employee.class);
	}

}
