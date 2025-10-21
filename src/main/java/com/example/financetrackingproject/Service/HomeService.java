package com.example.financetrackingproject.Service;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.financetrackingproject.Model.CategoryType;
import com.example.financetrackingproject.Repository.TransactionRepository;
import com.example.financetrackingproject.Repository.MonthlyGoalsRepository;

//Service class to handle logic fo the Home controller class (display statistics)
@Service
public class HomeService {
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private MonthlyGoalsRepository monthlyGoalsRepository;



    // Finds the income/expenses/investments related to a specific month
    public double findMoneyRelatedToCategoryOfMonth(LocalDate date, CategoryType categoryType) {
        int monthValue = date.getMonthValue();
        int yearValue = date.getYear();

        Double total = transactionRepository.getTotalByCategoryTypeAndMonth(categoryType, monthValue, yearValue);
        return total != null ? total : 0.0;
    }

    //Finds budget related to a specific month
    public double findBudgetForMonth(LocalDate date) {
        int monthValue = date.getMonthValue();
        int yearValue = date.getYear();

        Double total = monthlyGoalsRepository.getOverallBudgetByMonth(monthValue, yearValue);

        return total != null ? total : 0.0;
    }




    //Gets expenses from teh last N months
    public Map<LocalDate, Double> getLastNMonthsExpenses(int numberOfPriorMonthsToBeDisplayed) {
        Map<LocalDate, Double> expensesMap = new HashMap<>();
        LocalDate currentMonth = LocalDate.now();
        for (int i = 0; i < numberOfPriorMonthsToBeDisplayed; i++) {
            LocalDate month = currentMonth.minusMonths(i);
            double expenses = findMoneyRelatedToCategoryOfMonth(month, CategoryType.EXPENSE);
            expensesMap.put(month, expenses);
        }

        return expensesMap;
    }

    public Map<LocalDate, Double> getLastNMonthsIncome(int numberOfPriorMonthsToBeDisplayed) {
        Map<LocalDate, Double> incomeMap = new HashMap<>();
        LocalDate currentMonth = LocalDate.now();
        for (int i = 0; i < numberOfPriorMonthsToBeDisplayed; i++) {
            LocalDate month = currentMonth.minusMonths(i);
            double income = findMoneyRelatedToCategoryOfMonth(month, CategoryType.INCOME);
            incomeMap.put(month, income);
        }

        return incomeMap;
    }

    public Map<LocalDate, Double> getLastNBudgetMap(int numberOfPriorMonthsToBeDisplayed){
        Map<LocalDate, Double> budgetMap = new HashMap<>();
        LocalDate currentDate = LocalDate.now();
        for (int i = 0; i < numberOfPriorMonthsToBeDisplayed; i++){
            LocalDate month = currentDate.minusMonths(i);
            double budget = findBudgetForMonth(month);
            budgetMap.put(month, budget);
        }


        return budgetMap;
    }


    
}
