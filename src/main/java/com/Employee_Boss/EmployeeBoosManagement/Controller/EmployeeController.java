package com.Employee_Boss.EmployeeBoosManagement.Controller;

import com.Employee_Boss.EmployeeBoosManagement.Entity.Employee;
import com.Employee_Boss.EmployeeBoosManagement.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = employeeService.addEmployee(employee);
        return ResponseEntity.ok(savedEmployee);
    }
    @GetMapping("/filter")
    public ResponseEntity<List<Employee>> getEmployeesByAgeAndRating(
            @RequestParam Integer age,
            @RequestParam Float rating) {
        List<Employee> employees = employeeService.getEmployeesUnderAgeAndWithRating(age, rating);
        return ResponseEntity.ok(employees);
    }
    @GetMapping("/employees/count-by-rating")
    public long countEmployeesByBossAndEmployeeRating(
            @RequestParam Float ratingThreshold) {
        return employeeService.countEmployeesWithBossAndEmployeeRatingAbove(ratingThreshold);
    }


}
