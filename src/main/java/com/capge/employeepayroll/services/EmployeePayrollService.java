package com.capge.employeepayroll.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.capge.employeepayroll.dto.EmployeePayrollDTO;
import com.capge.employeepayroll.model.EmployeePayrollData;
@Service
public class EmployeePayrollService implements IEmployeePayrollService{
	private List<EmployeePayrollData> empPayrollList = new ArrayList<>();
	@Override
	public List<EmployeePayrollData> getEmployeePayrollData() {
		return empPayrollList;
	}
	@Override
	public EmployeePayrollData getEmployeePayrollDataById(int empId) {
		EmployeePayrollData empData = null;
		empData = empPayrollList.get(empId-1);
		return empData;
	}
	@Override
	public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
		EmployeePayrollData empData = null;
		empData = new EmployeePayrollData(empPayrollList.size()+1, empPayrollDTO);
		empPayrollList.add(empData);
		return empData;
	}
	@Override
	public EmployeePayrollData updateEmployeePayrollData(int id, EmployeePayrollDTO empPayrollDTO) {
		EmployeePayrollData empData = this.getEmployeePayrollDataById(id);
		empData.setName("Shubham Jangale");
		empData.setSalary(500);
		empPayrollList.set(id - 1, empData);
		return empData;
	}
	@Override
	public void deleteEmployeePayrollDataById(int empId) {
		empPayrollList.remove(empId - 1);
	}
}
