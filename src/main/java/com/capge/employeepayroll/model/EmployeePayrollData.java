package com.capge.employeepayroll.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import com.capge.employeepayroll.dto.EmployeePayrollDTO;

import lombok.Data;

@Entity
@Table(name = "employee_payroll")
public @Data class EmployeePayrollData {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "employee_id")
	private Long id;
	private String name;
	private Long salary;
	private String gender;
	@Column(name = "start_date")
	private LocalDate startDate;
	private String note;
	@Column(name = "profile_pic")
	private String profilePic;
	@ElementCollection
	@CollectionTable(name = "employee_department", joinColumns = @JoinColumn(name = "id"))
	@Column(name = "department")
	private List<String> departments;
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
		this.departments = employeeDTO.departments;
	}

}