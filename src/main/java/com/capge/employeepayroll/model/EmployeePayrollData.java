package com.capge.employeepayroll.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.capge.employeepayroll.dto.EmployeePayrollDTO;

import lombok.Data;

@Entity
@Table(name = "employee")
public @Data class EmployeePayrollData {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Long salary;
	private String gender;
	@Column(name = "start_date")
	private LocalDate startDate;
	private String note;
	private String profilePic;

	public EmployeePayrollData() {
	}
	
	public EmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
		this.updateEmployeePayrollData(employeePayrollDTO);
	}

	public void updateEmployeePayrollData(EmployeePayrollDTO employeeDTO) {
		this.name = employeeDTO.name;
		this.salary = employeeDTO.salary;
		this.gender = employeeDTO.gender;
		this.startDate = employeeDTO.startDate;
		this.note = employeeDTO.note;
		this.profilePic = employeeDTO.profilePic;
	}

}