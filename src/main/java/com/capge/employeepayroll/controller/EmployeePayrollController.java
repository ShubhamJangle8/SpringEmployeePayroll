package com.capge.employeepayroll.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capge.employeepayroll.dto.EmployeePayrollDTO;
import com.capge.employeepayroll.dto.ResponseDTO;
import com.capge.employeepayroll.exception.EmployeeException;
import com.capge.employeepayroll.model.EmployeePayrollData;
import com.capge.employeepayroll.services.IEmployeePayrollService;

@RestController
@RequestMapping("/hello")
public class EmployeePayrollController {
	@Autowired
	IEmployeePayrollService empService;

	@GetMapping(value= {"/","","/home"})
	public ResponseEntity<String> getEmployeeData() {
		return new ResponseEntity<String>("Get call success", HttpStatus.OK);
	}

	@GetMapping("/get/{empId}")
	public ResponseEntity<EmployeePayrollData> getEmployeeDataById(@PathVariable("empId") Long empId) throws EmployeeException {
		EmployeePayrollData emp = empService.getEmployeeById(empId);
		return new ResponseEntity<EmployeePayrollData>(emp, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<EmployeePayrollData> addEmployee(@Valid @RequestBody EmployeePayrollDTO employeeDTO) {
		EmployeePayrollData emp = empService.addEmployee(employeeDTO);
		return new ResponseEntity<EmployeePayrollData>(emp, HttpStatus.OK);
	}

	@PutMapping("/update/{empId}")
	public ResponseEntity<ResponseDTO> updateEmployee(@PathVariable("empId") Long empId,
			@RequestBody EmployeePayrollDTO employeeDTO) throws EmployeeException {
		empService.updateEmployeeById(empId, employeeDTO);
		ResponseDTO responseDTO = new ResponseDTO("Updated the Employee Data", getEmployeeDataById(empId));
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<String> deleteEmployeeById(@PathVariable("empId") Long empId) {
		empService.deleteEmployeeById(empId);
		return new ResponseEntity<String>("Deleted the employee with id : " + empId, HttpStatus.OK);
	}

	@GetMapping("/getall")
	public ResponseEntity<List<EmployeePayrollData>> getAllEmployees() {
		List employeesList = empService.getAllEmployees();
		return new ResponseEntity<>(employeesList, HttpStatus.OK);
	}
}