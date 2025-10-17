package com.example.financetrackingproject.Repository;

import com.example.financetrackingproject.Model.MonthlyGoals;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonthlyGoalsRepository extends JpaRepository<MonthlyGoals, LocalDate> {
}
