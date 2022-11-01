package com.software.employeeapp.services;

import java.util.List;

import com.software.employeeapp.entities.Employee;

public interface EmployeeServiceI {

	public Employee addEmployee(Employee employee);
	
	public Employee modifyEmployee(Employee employee, Long empId);
	
	public void deleteEmployee(Long empId);
	
	public List<Employee> getAllEmployee();
	
}
