package com.capge.employeepayroll.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.Data;

public @Data class EmployeePayrollDTO {
	@NotEmpty
	@Pattern(regexp = "^[A-Z]{1}[A-Za-z\\s]{2,}$", message = "Put an Employee valid name")
	public String name;
	@Min(value=500, message = "Minimum wage should be more than 500")
	public long salary;
	public EmployeePayrollDTO(String name, long salary) {
		this.name = name;
		this.salary = salary;
	}
}
