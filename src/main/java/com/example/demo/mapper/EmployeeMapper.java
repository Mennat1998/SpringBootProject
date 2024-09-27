package com.example.demo.mapper;

import java.util.List;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.Employee;

@Mapper
public interface EmployeeMapper {

	@Mapping(source="firstName", target="empFirstName")
	@Mapping(source="lastName", target="empLastName")
	@Mapping(source="salary", target="empSalary")
	@Mapping(source="hireDate", target="empHireDate")
	@Mapping(target="empFullName",ignore=true)
	EmployeeDto map(Employee entity);
	
	
	
	
	List<EmployeeDto> map(List<Employee> entities);
	
	
	
	
	@AfterMapping
	default void handlefullName(Employee entity,@MappingTarget EmployeeDto dto)
	{
		if(entity.getFirstName() !=null && entity.getLastName() !=null)
		{
			dto.setEmpFullName(entity.getFirstName()+' '+ entity.getLastName() );
		}
	}
	
	
	//it creates new object
	@Mapping(source="empFirstName", target="firstName")
	@Mapping(source="empLastName", target="lastName")
	@Mapping(source="empSalary", target="salary")
	@Mapping(source="empHireDate", target="hireDate")
	Employee UnMap(EmployeeDto dto);
	
	
	// this method is used in updating it doesn't not create new object
	@Mapping(source="empFirstName", target="firstName")
	@Mapping(source="empLastName", target="lastName")
	@Mapping(source="empSalary", target="salary")
	@Mapping(source="empHireDate", target="hireDate")
	Employee UnMap(EmployeeDto dto,@MappingTarget Employee entity);
	
	
}
