package com.software.employeeapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.software.employeeapp.entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	// All CRUD Database Methods
}
