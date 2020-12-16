package com.capge.employeepayroll.services;

import java.util.List;

import com.capge.employeepayroll.dto.EmployeePayrollDTO;
import com.capge.employeepayroll.exception.EmployeePayrollException;
import com.capge.employeepayroll.model.EmployeePayrollData;

public interface IEmployeePayrollService {
	public EmployeePayrollData addEmployee(EmployeePayrollDTO employeeDTO);
	
	public void updateEmployeeById(Long id, EmployeePayrollDTO employeeDTO) throws EmployeePayrollException;

	public EmployeePayrollData getEmployeeById(Long id) throws EmployeePayrollException;

	public void deleteEmployeeById(Long id);

	public List<EmployeePayrollData> getAllEmployees();

}
