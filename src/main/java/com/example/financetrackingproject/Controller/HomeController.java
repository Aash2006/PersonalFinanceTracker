package com.example.financetrackingproject.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


import com.example.financetrackingproject.Service.HomeService;

import org.springframework.ui.Model;



/*
 * Controller class that handles http requests related to the home page.
 * Allows traversing the website and displayss statistics on the home page.
 */
@Controller
public class HomeController {

    private final HomeService homeService;

    public HomeController(HomeService homeService){
        this.homeService = homeService;
    }



    @GetMapping("/")
    public String showHome(Model model) {
        //Gets the expenses in teh last 6 months.
        model.addAttribute("expensesMap", homeService.getLastNMonthsExpenses(6));


        return "home"; 
    }
}
