package com.capge.employeepayroll.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capge.employeepayroll.dto.EmployeePayrollDTO;
import com.capge.employeepayroll.exception.EmployeeException;
import com.capge.employeepayroll.model.EmployeePayrollData;
import com.capge.employeepayroll.repository.IEmployeeRepository;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {
	@Autowired
	IEmployeeRepository employeeRepository;

	@Override
	public EmployeePayrollData addEmployee(EmployeePayrollDTO employeeDTO) {
		EmployeePayrollData emp = new EmployeePayrollData(employeeDTO);
		emp = employeeRepository.save(emp);
		return emp;
	}
	@Override
	public EmployeePayrollData getEmployeeById(Long id) throws EmployeeException {
		return employeeRepository.findById(id).orElseThrow(() -> new EmployeeException("Invalid User id"));
	}
	@Override
	public void updateEmployeeById(Long id, EmployeePayrollDTO employeeDTO) throws EmployeeException {
		EmployeePayrollData emp = getEmployeeById(id);
		if (employeeDTO.name != null) {
			emp.setName(employeeDTO.name);
		}
		if (employeeDTO.salary != 0.0) {
			emp.setSalary(employeeDTO.salary);
		}
		employeeRepository.save(emp);
	}

	@Override
	public void deleteEmployeeById(Long id) {
		employeeRepository.deleteById(id);
	}

	@Override
	public List getAllEmployees() {
		return (List) employeeRepository.findAll();
	}
}