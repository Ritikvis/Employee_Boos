package com.Employee_Boss.EmployeeBoosManagement.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Boss {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Ensure this is a Long

    private String name;
    private Integer age;
    private Float salary;
    private Float rating;

    @OneToMany(mappedBy = "boss", cascade = CascadeType.ALL)
    private List<Employee> employees;
}
