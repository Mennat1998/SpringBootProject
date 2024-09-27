package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.repository.EmployeeRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{
	

	private final EmployeeRepo employeeRepo ;
	
	private final EmployeeMapper employeeMapper;
	
	public Employee findById(Long id)
	{
		//findById return optional 
		return employeeRepo.findById(id).orElse(null);
	}

	@Override
	public Employee findEmployeeByFirstNameAndLastNameOrderById(String firstName, String lastName) {
		// TODO Auto-generated method stub
		return employeeRepo.findEmployeeByFirstNameAndLastNameOrderById(firstName, lastName);
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return employeeRepo.findAll();
	}

	@Override
	public Employee insert(Employee emp) {
		// TODO Auto-generated method stub
		return employeeRepo.save(emp);
	}

	@Override
	public Employee Update(Employee emp) {
		
			return employeeRepo.save(emp);
	}

	@Override
	public void deleteById(Long id) {
		Employee currentEmp= employeeRepo.findById(id).orElse(null);
		if(currentEmp !=null)
		{
			employeeRepo.deleteById(id);
		}
	}

}
