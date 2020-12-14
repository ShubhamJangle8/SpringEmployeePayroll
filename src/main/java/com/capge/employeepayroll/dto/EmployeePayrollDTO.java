package com.capge.employeepayroll.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

public @Data class EmployeePayrollDTO {
	@NotEmpty(message = "Name should not be null")
	public String name;
	@NotNull
	public long salary;
	public EmployeePayrollDTO(String name, long salary) {
		this.name = name;
		this.salary = salary;
	}
}
