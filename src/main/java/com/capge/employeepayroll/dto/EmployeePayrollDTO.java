package com.capge.employeepayroll.dto;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
@AllArgsConstructor
public @Data class EmployeePayrollDTO {
	@NotEmpty
	@Pattern(regexp = "^[A-Z]{1}[A-Za-z\\s]{2,}$", message = "Put an Employee valid name")
	public String name;	
	@Min(value=500, message = "Minimum wage should be more than 500")
	public long salary;
	@Pattern(regexp="male|female", message="Gender needs to be male or female")
	public String gender;
	@JsonFormat(pattern="yyyy-mm-dd")
	@NotNull(message = "startDate should not be empty")
	@PastOrPresent(message = "startDate should be past or today's date")
	public LocalDate startDate;
	@NotBlank(message = "Note cannot be Empty")
	public String note;
	@NotNull(message = "ProfilePic cannot be Empty")
	public String profilePic;
}
