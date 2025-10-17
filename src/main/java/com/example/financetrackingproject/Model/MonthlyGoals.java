package com.example.financetrackingproject.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "monthly_goals")
public class MonthlyGoals {

    @Id
    @NotNull
    @Column(unique = true)
    private LocalDate month;  // Primary key, only one goal for each month, will always be unique

    private Double overallBudget;

    private Double savingsGoal;

    private Double incomeTarget;


    public MonthlyGoals() {}


    // Getters and setters
    public LocalDate getMonth() {
        return month;
    }

    public void setMonth(LocalDate month) {
        this.month = month;
    }

    public Double getOverallBudget() {
        return overallBudget;
    }

    public void setOverallBudget(Double overallBudget) {
        this.overallBudget = overallBudget;
    }

    public Double getSavingsGoal() {
        return savingsGoal;
    }

    public void setSavingsGoal(Double savingsGoal) {
        this.savingsGoal = savingsGoal;
    }

    public Double getIncomeTarget() {
        return incomeTarget;
    }

    public void setIncomeTarget(Double incomeTarget) {
        this.incomeTarget = incomeTarget;
    }
}
