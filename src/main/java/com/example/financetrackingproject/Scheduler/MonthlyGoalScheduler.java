

package com.example.financetrackingproject.Scheduler;

import com.example.financetrackingproject.Service.MonthlyGoalsService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Component
public class MonthlyGoalScheduler {

    private final MonthlyGoalsService monthlyGoalsService;

    public MonthlyGoalScheduler(MonthlyGoalsService monthlyGoalsService) {
        this.monthlyGoalsService = monthlyGoalsService;
    }

    // Runs at midnight on the 1st day of every month
    @Scheduled(cron = "0 0 0 1 * ?")
    public void checkForMissingMonthlyGoals() {
        LocalDate currentMonth = LocalDate.now().withDayOfMonth(1);
        boolean goalsExist = monthlyGoalsService.existsByMonth(currentMonth);

        if (!goalsExist) {

            System.out.println("No MonthlyGoals found for " + currentMonth + ". Prompt user to set them.");
        } else {
            System.out.println("MonthlyGoals already exist for " + currentMonth);
        }
    }
}
