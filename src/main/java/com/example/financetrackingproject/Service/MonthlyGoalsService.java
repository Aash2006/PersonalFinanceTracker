package com.example.financetrackingproject.Service;

import com.example.financetrackingproject.Model.MonthlyGoals;
import com.example.financetrackingproject.Repository.MonthlyGoalsRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

/*
 * Service Class to handle logic for the monthly goals controller.
 */
@Service
public class MonthlyGoalsService {

    private final MonthlyGoalsRepository repository;

    public MonthlyGoalsService(MonthlyGoalsRepository repository) {
        this.repository = repository;
    }


    public List<MonthlyGoals> findAll() {
        return repository.findAll();
    }


    public MonthlyGoals getGoalsForCurrentMonth() {
        LocalDate currentMonth = LocalDate.now().withDayOfMonth(1);
        return repository.findById(currentMonth).orElse(null);
    }


    public MonthlyGoals findByMonth(LocalDate month) {
        return repository.findById(month.withDayOfMonth(1)).orElse(null);
    }

 
    public MonthlyGoals save(MonthlyGoals goals) {
        goals.setMonth(goals.getMonth().withDayOfMonth(1)); // Normalize to first of month
        return repository.save(goals);
    }


    public void deleteByMonth(LocalDate month) {
        repository.deleteById(month.withDayOfMonth(1));
    }

    public boolean existsByMonth(LocalDate month) {
        return repository.existsById(month.withDayOfMonth(1));
    }

    //Checks if the current month is a month passed.
    public boolean isCurrentMonth(LocalDate currentDate){
        Month currentMonth = LocalDate.now().getMonth();
        return currentMonth.equals(currentDate.getMonth());
    
    }


  
}
