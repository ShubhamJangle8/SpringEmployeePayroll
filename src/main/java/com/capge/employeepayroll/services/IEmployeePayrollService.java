package com.capge.employeepayroll.services;

import java.util.List;

import com.capge.employeepayroll.dto.EmployeePayrollDTO;
import com.capge.employeepayroll.exception.EmployeeException;
import com.capge.employeepayroll.model.EmployeePayrollData;

public interface IEmployeePayrollService {
	public EmployeePayrollData addEmployee(EmployeePayrollDTO employeeDTO);
	
	public void updateEmployeeById(Long id, EmployeePayrollDTO employeeDTO) throws EmployeeException;

	public EmployeePayrollData getEmployeeById(Long id) throws EmployeeException;

	public void deleteEmployeeById(Long id);

	public List getAllEmployees();

}
