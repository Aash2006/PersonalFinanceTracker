package com.example.financetrackingproject.Repository;

import com.example.financetrackingproject.Model.MonthlyGoals;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MonthlyGoalsRepository extends JpaRepository<MonthlyGoals, LocalDate> {
    @Query("SELECT m.overallBudget FROM MonthlyGoals m " +
       "WHERE MONTH(m.month) = :month " +
       "AND YEAR(m.month) = :year")
        Double getOverallBudgetByMonth(
        @Param("month") int month,  
        @Param("year") int year
);
}
