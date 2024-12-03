package com.Employee_Boss.EmployeeBoosManagement.Controller;

import com.Employee_Boss.EmployeeBoosManagement.Entity.Boss;
import com.Employee_Boss.EmployeeBoosManagement.Service.BossService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bosses")
public class BossController {
    @Autowired
    private BossService bossService;


//    http://localhost:8080/api/bosses/add
    @PostMapping("add")
    public ResponseEntity<Boss> addBoss(@RequestBody Boss boss) {
        Boss savedBoss = bossService.addBoss(boss);
        return ResponseEntity.ok(savedBoss);
    }


//    http://localhost:8080/api/employees/update-salaries?increment=5000&ratingThreshold=4.6
    @PutMapping("/update-salaries")
    public String updateBossSalaries(
            @RequestParam Float increment,
            @RequestParam Float ratingThreshold) {
        bossService.updateBossSalaries(increment, ratingThreshold);
        return "Boss salaries updated successfully.";
    }
}
