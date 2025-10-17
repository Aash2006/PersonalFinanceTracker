package com.example.financetrackingproject.Controller;

import com.example.financetrackingproject.Model.Transaction;
import com.example.financetrackingproject.Service.CategoryService;
import com.example.financetrackingproject.Service.TransactionService;
import com.example.financetrackingproject.Model.Category;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/*
 * Controller class that handles http requests for /transactions.
 * Provides functionality to add/edit/delete/view transactions.
 */
@Controller
public class TransactionController {


    private final CategoryService categoryService;
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService, CategoryService categoryService) {
        this.transactionService = transactionService;
        this.categoryService = categoryService; 
    }


    @GetMapping("/transactions")
    public String viewTransactions(Model model) {
        model.addAttribute("transactions", transactionService.findAll());
        model.addAttribute("newTransaction", new Transaction());
        model.addAttribute("categories", categoryService.findAll()); 
        return "transactions"; 
    }


    @PostMapping("/transactions")
    public String addTransaction(@ModelAttribute("newTransaction") Transaction transaction) {
        transactionService.save(transaction);
        return "redirect:/transactions";
    }

    @PostMapping("/transactions/delete/{id}")
    public String deleteTransaction(@PathVariable long id) {
        transactionService.deleteById(id);
        return "redirect:/transactions";
    }


    @GetMapping("/transactions/edit/{id}")
    public String editTransaction(@PathVariable Long id, Model model) {
        Transaction transaction = transactionService.findById(id);
        List<Category> categories = categoryService.findAll();
        model.addAttribute("transaction", transaction);
        model.addAttribute("categories", categories);
        return "edit-transaction";
}


    @PostMapping("/transactions/update/{id}")
    public String updateTransaction(@PathVariable Long id, @ModelAttribute Transaction transaction) {
        transactionService.update(id, transaction);
        return "redirect:/transactions";
}
}