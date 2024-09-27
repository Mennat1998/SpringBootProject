package com.example.demo.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDto {

	private Long id ;
	
	private String empFullName ;
	
	private String empFirstName ;
	
	private String empLastName ;
	
	private double empSalary ;
	
	private  LocalDate empHireDate;
}
