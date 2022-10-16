package com.employee.service;

import java.util.List;

import com.employee.model.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployees();
	
	void save(Employee employee);
	
	Employee getById(long id);
	
	void deleteById(long id);
	
}
