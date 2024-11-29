package com.Employee_Boss.EmployeeBoosManagement.Repository;

import com.Employee_Boss.EmployeeBoosManagement.Entity.Boss;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BossRepository extends JpaRepository<Boss, String> {
}