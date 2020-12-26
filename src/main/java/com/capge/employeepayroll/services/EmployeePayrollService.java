package com.capge.employeepayroll.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capge.employeepayroll.dto.EmployeePayrollDTO;
import com.capge.employeepayroll.exception.EmployeePayrollException;
import com.capge.employeepayroll.model.EmployeePayrollData;
import com.capge.employeepayroll.repository.IEmployeeRepository;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class EmployeePayrollService implements IEmployeePayrollService {
	@Autowired
	IEmployeeRepository employeeRepository;

	@Override
	public EmployeePayrollData addEmployee(EmployeePayrollDTO employeeDTO) {
		EmployeePayrollData emp = new EmployeePayrollData(employeeDTO);
		log.info(emp.toString());
		emp = employeeRepository.save(emp);
		return emp;
	}
	@Override
	public EmployeePayrollData getEmployeeById(Long id) throws EmployeePayrollException {
		EmployeePayrollData empData = employeeRepository.findById(id).orElseThrow(() -> new EmployeePayrollException("Invalid User id"));
		log.info(empData.toString());
		return empData;
	}
	
	@Override
	public List<EmployeePayrollData> getEmployeeByDepartment(String department) {
		return employeeRepository.findEmployeeByDepartment(department);
	}
	
	@Override
	public void updateEmployeeById(Long id, EmployeePayrollDTO employeeDTO) throws EmployeePayrollException {
		EmployeePayrollData emp = getEmployeeById(id);
		emp.setName(employeeDTO.name);
		emp.setSalary(employeeDTO.salary);
		emp.setDepartment(employeeDTO.department);
		emp.setGender(employeeDTO.gender);
		emp.setNotes(employeeDTO.notes);
		emp.setProfile(employeeDTO.profile);
		emp.setStartDate(employeeDTO.startDate);
		employeeRepository.save(emp);
	}

	@Override
	public void deleteEmployeeById(Long id) {
		employeeRepository.deleteById(id);
	}

	@Override
	public List<EmployeePayrollData> getAllEmployees() {
		return (List<EmployeePayrollData>) employeeRepository.findAll();
	}
	
}