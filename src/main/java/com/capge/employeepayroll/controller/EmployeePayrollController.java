package com.capge.employeepayroll.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.capge.employeepayroll.dto.EmployeePayrollDTO;
import com.capge.employeepayroll.dto.ResponseDTO;
import com.capge.employeepayroll.model.EmployeePayrollData;
import com.capge.employeepayroll.services.IEmployeePayrollService;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {
	@Autowired
	public IEmployeePayrollService employeePayrollService;
	
	@RequestMapping(value = {"", "/", "/home"})
	public ResponseEntity<ResponseDTO> getEmployeePayrollData(){
		List<EmployeePayrollData> empData = null;
		empData = employeePayrollService.getEmployeePayrollData();
		ResponseDTO respDTO =new ResponseDTO("Get Call Success", empData);
		return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
	}
	@GetMapping("get/{empId}")
	public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("empId") int empId){
		EmployeePayrollData empData = null;
		empData = employeePayrollService.getEmployeePayrollDataById(empId);
		ResponseDTO respDTO =new ResponseDTO("Get Call Success", empData);
		return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
	}
	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> addEmployeePayrollData(@RequestBody EmployeePayrollDTO empPayrollDTO){
		EmployeePayrollData empData = null;
		empData = employeePayrollService.createEmployeePayrollData(empPayrollDTO);
		ResponseDTO respDTO =new ResponseDTO("Create Call Success", empData);
		return new ResponseEntity<ResponseDTO>(respDTO ,HttpStatus.OK);
	}
	@PutMapping("/update/{empId}")
	public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@PathVariable("empId") int empId ,@RequestBody EmployeePayrollDTO empPayrollDTO){
		EmployeePayrollData empData = null;
		empData = employeePayrollService.updateEmployeePayrollData(empId, empPayrollDTO);
		ResponseDTO respDTO =new ResponseDTO("Updated Call Success", empData);
		return new ResponseEntity<ResponseDTO>(respDTO ,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<String> deleteEmployeePayrollData(@PathVariable("empId") int empId){
		employeePayrollService.deleteEmployeePayrollDataById(empId);
		return new ResponseEntity<String>("Deleted the employee payroll DTO object of ID " + empId,HttpStatus.OK);
	}
}
