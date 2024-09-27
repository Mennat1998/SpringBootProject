package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Employee;

public interface EmployeeService {

	Employee findById(Long id);
	
	Employee findEmployeeByFirstNameAndLastNameOrderById(String firstName, String lastName);

	List<Employee> findAll();

	Employee insert(Employee emp);

	Employee Update(Employee emp);

	void deleteById(Long id);

}
