package com.software.employeeapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.software.employeeapp.entities.Employee;
import com.software.employeeapp.exceptions.ResourceNotFoundException;
import com.software.employeeapp.repositories.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeServiceI {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee addEmployee(Employee employee) {

		Employee addedEmployee = employeeRepository.save(employee);
		return addedEmployee;
	}

	@Override
	public Employee modifyEmployee(Employee employee, Long empId) {

		Employee emp = this.employeeRepository.findById(empId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee", "Employee Id", empId));

		emp.setFirstName(employee.getFirstName());
		emp.setLastName(employee.getLastName());
		emp.setEmailId(employee.getEmailId());

		Employee updatedEmployee = this.employeeRepository.save(emp);
		return updatedEmployee;
	}

	@Override
	public void deleteEmployee(Long empId) {

		Employee employee = this.employeeRepository.findById(empId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee", "Employee Id", empId));
		this.employeeRepository.delete(employee);
	}

	@Override
	public List<Employee> getAllEmployee() {
		
		List<Employee> allEmployee = this.employeeRepository.findAll();
		return allEmployee;
	}
}
