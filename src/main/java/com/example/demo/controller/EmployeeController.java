package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.Employee;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

	private final EmployeeService employeeService;

	private final EmployeeMapper employeeMapper;

	@GetMapping("/{id}")
	public ResponseEntity<EmployeeDto> findById(@PathVariable Long id) {
		Employee emp = employeeService.findById(id);

		EmployeeDto dto = employeeMapper.map(emp);
		return ResponseEntity.ok(dto);
	}
	
	
	@GetMapping("/filter")
	public ResponseEntity<EmployeeDto> findEmployeeByFirstNameAndLastNameOrderById(@RequestParam
			String firstName,@RequestParam String lastName) {	
		Employee emp = employeeService.findEmployeeByFirstNameAndLastNameOrderById(firstName,lastName);

		EmployeeDto dto = employeeMapper.map(emp);
		return ResponseEntity.ok(dto);
	}
	
	@GetMapping()
	public ResponseEntity<List<EmployeeDto>> findAll() {
		
		List<Employee> emps = employeeService.findAll();

		List<EmployeeDto> dtos = employeeMapper.map(emps);
		return ResponseEntity.ok(dtos);
	}
	
	
	
	@PostMapping()
	public ResponseEntity<EmployeeDto> insert(@RequestBody EmployeeDto empdto) {
		Employee emp=employeeMapper.UnMap(empdto);
		Employee empInserted= employeeService.insert(emp);

		EmployeeDto dto = employeeMapper.map(empInserted);
		return ResponseEntity.ok(dto);
	}

	@PutMapping()
	public ResponseEntity<EmployeeDto> update(@RequestBody EmployeeDto empdto) {
		Employee empSaved=employeeService.findById(empdto.getId());
		Employee emp=employeeMapper.UnMap(empdto,empSaved);
		Employee empUpdated= employeeService.Update(emp);
		
		EmployeeDto dto = employeeMapper.map(empUpdated);
		return ResponseEntity.ok(dto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id) {
		 employeeService.deleteById(id);
		return ResponseEntity.ok(null);
	}
	
}
