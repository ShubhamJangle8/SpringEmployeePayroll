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
import org.springframework.web.bind.annotation.RestController;

import com.capge.employeepayroll.dto.EmployeePayrollDTO;
import com.capge.employeepayroll.dto.ResponseDTO;
import com.capge.employeepayroll.exception.EmployeePayrollException;
import com.capge.employeepayroll.model.EmployeePayrollData;
import com.capge.employeepayroll.services.IEmployeePayrollService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/hello")
@Slf4j
public class EmployeePayrollController {
	@Autowired
	IEmployeePayrollService empService;

	@GetMapping(value= {"/","","/home"})
	public ResponseEntity<String> getEmployeeData() {
		return new ResponseEntity<String>("Get call success", HttpStatus.OK);
	}

	@GetMapping("/get/{empId}")
	public ResponseEntity<ResponseDTO> getEmployeeDataById(@PathVariable("empId") Long empId) throws EmployeePayrollException{
		EmployeePayrollData emp = empService.getEmployeeById(empId);
		ResponseDTO responseDTO = new ResponseDTO("Got the Employee Data for id " + empId, emp);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}
	
	@GetMapping("/department/{department}")
	public ResponseEntity<ResponseDTO> getEmployeeData(@PathVariable("department") String department){
		ResponseDTO responseDTO = new ResponseDTO("Got the Employees for the department", empService.getEmployeeByDepartment(department));
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> addEmployee(@Valid @RequestBody EmployeePayrollDTO employeeDTO) {
		log.debug("Employee DTO : " + employeeDTO.toString());
		EmployeePayrollData emp = empService.addEmployee(employeeDTO);
		ResponseDTO responseDTO = new ResponseDTO("Created the Employee Data", emp);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@PutMapping("/update/{empId}")
	public ResponseEntity<ResponseDTO> updateEmployee(@Valid @PathVariable("empId") Long empId,@Valid
			@RequestBody EmployeePayrollDTO employeeDTO) throws EmployeePayrollException {
		empService.updateEmployeeById(empId, employeeDTO);
		ResponseDTO responseDTO = new ResponseDTO("Updated the Employee Data", getEmployeeDataById(empId));
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<ResponseDTO> deleteEmployeeById(@PathVariable("empId") Long empId) {
		empService.deleteEmployeeById(empId);
		String message = "Deleted the employee with id : " + empId;
		ResponseDTO responseDTO = new ResponseDTO("Deleted the Employee Data", message);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@GetMapping("/getall")
	public ResponseEntity<ResponseDTO> getAllEmployees() {
		List<EmployeePayrollData> employeesList = empService.getAllEmployees();
		ResponseDTO responseDTO = new ResponseDTO("Got the Employee Data", employeesList);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}
}