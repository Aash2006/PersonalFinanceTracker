package com.example.financetrackingproject.Controller;

import com.example.financetrackingproject.Model.MonthlyGoals;
import com.example.financetrackingproject.Service.MonthlyGoalsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/*
 * Controller class that handles requests related to monthly goals.
 * Allows viewing, adding, updating and editting goals.
 * Can oinly edit this months goals, not previous months.
 */
@Controller
@RequestMapping("/goals")
public class MonthlyGoalsController {

    private final MonthlyGoalsService monthlyGoalsService;

    public MonthlyGoalsController(MonthlyGoalsService monthlyGoalsService) {
        this.monthlyGoalsService = monthlyGoalsService;
    }

    @GetMapping
    public String viewGoalsPage(Model model) {
        List<MonthlyGoals> allGoals = monthlyGoalsService.findAll();
        LocalDate currentMonth = LocalDate.now().withDayOfMonth(1); //All monthly goals should be set from the first day of the month.

        // Try to get current month goals
        MonthlyGoals currentMonthGoal = monthlyGoalsService.findByMonth(currentMonth);

        // If none exists, create a blank object for the form
        if (currentMonthGoal == null) {
            currentMonthGoal = new MonthlyGoals();  
            currentMonthGoal.setMonth(currentMonth);
        }

        model.addAttribute("allGoals", allGoals);
        model.addAttribute("newGoal", currentMonthGoal);

        model.addAttribute("currentMonth", currentMonth);

        return "goals"; 
    }


    @PostMapping
    public String saveCurrentMonthGoal(@ModelAttribute("newGoal") MonthlyGoals goal) {
        // Normalize the month to the 1st day
        goal.setMonth(goal.getMonth().withDayOfMonth(1));
        //Overrites current month goal.
        monthlyGoalsService.save(goal);
        return "redirect:/goals";
    }


    @PostMapping("/delete/{year}/{month}")
    public String deleteMonthlyGoal(@PathVariable int year, @PathVariable int month) {
        LocalDate date = LocalDate.of(year, month, 1);
        monthlyGoalsService.deleteByMonth(date);
        return "redirect:/goals";
    }


    @GetMapping("/{year}/{month}")
    public String viewSpecificMonth(@PathVariable int year, @PathVariable int month, Model model) {
        LocalDate date = LocalDate.of(year, month, 1);
        MonthlyGoals goals = monthlyGoalsService.findByMonth(date);
 
        model.addAttribute("specificMonth", goals);
        return "goals"; 
    }



}
