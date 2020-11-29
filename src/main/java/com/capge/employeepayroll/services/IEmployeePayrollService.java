package com.capge.employeepayroll.services;

import java.util.List;

import com.capge.employeepayroll.dto.EmployeePayrollDTO;
import com.capge.employeepayroll.model.EmployeePayrollData;
public interface IEmployeePayrollService {
	List<EmployeePayrollData> getEmployeePayrollData();
	
	EmployeePayrollData getEmployeePayrollDataById(int empId);
	EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO);
	EmployeePayrollData updateEmployeePayrollData(int id, EmployeePayrollDTO employeePayrollDTO);
	void deleteEmployeePayrollDataById(int empId);
}
