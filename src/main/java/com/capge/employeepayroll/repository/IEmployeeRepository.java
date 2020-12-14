package com.capge.employeepayroll.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capge.employeepayroll.model.EmployeePayrollData;
@Repository
public interface IEmployeeRepository extends JpaRepository<EmployeePayrollData, Long> {

}
