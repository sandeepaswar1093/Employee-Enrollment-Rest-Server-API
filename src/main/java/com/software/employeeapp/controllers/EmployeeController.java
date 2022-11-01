package com.software.employeeapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.software.employeeapp.entities.Employee;
import com.software.employeeapp.payloads.ApiResponse;
import com.software.employeeapp.services.EmployeeServiceI;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	// Injecting EmployeeService into EmployeeController
	@Autowired
	private EmployeeServiceI employeeServiceI;

	// method to create employee record
	@PostMapping("/add/")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {

		Employee emp = this.employeeServiceI.addEmployee(employee);
		return new ResponseEntity<Employee>(emp, HttpStatus.CREATED);
	}
	
	// method to update employee record
	@PutMapping("/modify/{empId}")
	public ResponseEntity<Employee> modifyEmployee(@RequestBody Employee employee, @PathVariable Long empId)
	{
		Employee modifiedEmployee = this.employeeServiceI.modifyEmployee(employee, empId);
		
		return new ResponseEntity<Employee>(modifiedEmployee,HttpStatus.OK);
		
	}
	
	// method to delete an employee
	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<ApiResponse> deleteEmployee(@PathVariable Long empId)
	{
		this.employeeServiceI.deleteEmployee(empId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Employee Deleted Successfully!!",true),HttpStatus.OK);
	}
	
	//method to find all Employees
	
	@GetMapping("/getAll/")
	public ResponseEntity<List<Employee>> getAllEmployees()
	{
		List<Employee> allEmployee = this.employeeServiceI.getAllEmployee();
		return new ResponseEntity<List<Employee>>(allEmployee,HttpStatus.OK);
		
	}

}
