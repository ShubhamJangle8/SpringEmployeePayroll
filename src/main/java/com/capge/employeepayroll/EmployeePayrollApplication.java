package com.capge.employeepayroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import lombok.extern.slf4j.Slf4j;
@SpringBootApplication
@Slf4j
public class EmployeePayrollApplication {
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(EmployeePayrollApplication.class, args);
		log.info("Employee Payroll App started in {} environment", context.getEnvironment().getProperty("environment"));
		log.info("Employee Payroll DB user is {} ", context.getEnvironment().getProperty("spring.datasource.username"));
	}
	
}
