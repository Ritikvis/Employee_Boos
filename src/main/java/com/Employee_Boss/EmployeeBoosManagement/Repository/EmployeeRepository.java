package com.Employee_Boss.EmployeeBoosManagement.Repository;

import com.Employee_Boss.EmployeeBoosManagement.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {
}