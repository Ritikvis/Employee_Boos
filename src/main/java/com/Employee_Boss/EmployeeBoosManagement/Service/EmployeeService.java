package com.Employee_Boss.EmployeeBoosManagement.Service;

import com.Employee_Boss.EmployeeBoosManagement.Entity.Boss;
import com.Employee_Boss.EmployeeBoosManagement.Entity.Employee;
import com.Employee_Boss.EmployeeBoosManagement.Repository.BossRepository;
import com.Employee_Boss.EmployeeBoosManagement.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private BossRepository bossRepository;


    public long countEmployeesWithBossAndEmployeeRatingAbove(Float ratingThreshold) {
        // Fetch all employees
        List<Employee> allEmployees = employeeRepository.findAll();

        // Count employees who satisfy the condition
        long count = 0;
        for (Employee employee : allEmployees) {
            if (employee.getRating() > ratingThreshold && employee.getBoss().getRating() > ratingThreshold) {
                count++;
            }
        }

        return count;
    }
    public List<Employee> getEmployeesUnderAgeAndWithRating(Integer age, Float rating) {
        // Fetch all employees from the repository
        List<Employee> allEmployees = employeeRepository.findAll();

        // Create a list to hold the filtered employees
        List<Employee> filteredEmployees = new ArrayList<>();

        // Iterate over the employees and add those that meet the criteria
        for (Employee employee : allEmployees) {
            if (employee.getAge() < age && employee.getRating() > rating) {
                filteredEmployees.add(employee);
            }
        }

        return filteredEmployees;
    }

    public Employee addEmployee(Employee employee, Long bossId) {
        Boss boss = bossRepository.findById(String.valueOf(bossId))
                .orElseThrow(()-> new RuntimeException("Id Not found"));
        employee.setBoss(boss);
        return  employeeRepository.save(employee);
    }
}
