package com.Employee_Boss.EmployeeBoosManagement.Service;

import com.Employee_Boss.EmployeeBoosManagement.Entity.Boss;
import com.Employee_Boss.EmployeeBoosManagement.Repository.BossRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BossService {
    @Autowired
    private BossRepository bossRepository;

    public Boss addBoss(Boss boss) {
        return bossRepository.save(boss);
    }
    public void updateBossSalaries(Float increment, Float ratingThreshold) {
        // Fetch all bosses
        List<Boss> bosses = bossRepository.findAll();

        // Update salaries conditionally
        for (Boss boss : bosses) {
            if (boss.getRating() > ratingThreshold) {
                boss.setSalary(boss.getSalary() + increment);
            }
        }

        // Save the updated bosses back to the database
        bossRepository.saveAll(bosses);
    }
}
