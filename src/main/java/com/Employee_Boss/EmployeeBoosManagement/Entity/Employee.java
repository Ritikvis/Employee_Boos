package com.Employee_Boss.EmployeeBoosManagement.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer age;
    private Float salary;
    private Float rating;

    @ManyToOne
    @JoinColumn(name = "boss_id")
    private Boss boss;
}
