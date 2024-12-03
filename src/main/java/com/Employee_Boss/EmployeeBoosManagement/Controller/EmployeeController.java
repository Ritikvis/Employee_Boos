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


//    http://localhost:8080/api/employees/add?bossId=1
    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(
            @RequestBody Employee employee,
            @RequestParam Long bossId) {
        Employee savedEmployee = employeeService.addEmployee(employee, bossId);
        return ResponseEntity.ok(savedEmployee);
    }


//    http://localhost:8080/api/employees/filter?age=37&rating=4.8
    @GetMapping("/filter")
    public ResponseEntity<List<Employee>> getEmployeesByAgeAndRating(
            @RequestParam Integer age,
            @RequestParam Float rating) {
        List<Employee> employees = employeeService.getEmployeesUnderAgeAndWithRating(age, rating);
        return ResponseEntity.ok(employees);
    }


//    http://localhost:8080/api/employees/count-by-rating?ratingThreshold=4.3
    @GetMapping("/count-by-rating")
    public long countEmployeesByBossAndEmployeeRating(
            @RequestParam Float ratingThreshold) {
        return employeeService.countEmployeesWithBossAndEmployeeRatingAbove(ratingThreshold);
    }


}
