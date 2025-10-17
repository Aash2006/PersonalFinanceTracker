package com.example.financetrackingproject.Controller;

import org.springframework.stereotype.Controller;
import com.example.financetrackingproject.Service.CategoryService;
import com.example.financetrackingproject.Model.Category;
import com.example.financetrackingproject.Model.CategoryType;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
/*
 * Controller classs to handle HTTP requests related to categories of spending.
 * Functionality to display, add, edit and delete categories
 */
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;

    }

    @GetMapping("/categories")
    public String viewCategories(Model model){
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("newCategory", new Category());
        model.addAttribute("typeOfCategory", CategoryType.values());
        return "categories";
    }

    @PostMapping("/categories")
    public String addCategory(@ModelAttribute("newCategory") Category category) {
        categoryService.save(category);
        return "redirect:/categories";
    }
    @PostMapping("/categories/delete/{id}")
    public String deleteCategory(@PathVariable Long id) {
        categoryService.deleteById(id);
        return "redirect:/categories";
    }

    @GetMapping("/categories/edit/{id}")
    public String editCategory(@PathVariable Long id, Model model) {
        Category category = categoryService.findById(id);
        model.addAttribute("category", category);
        model.addAttribute("typeOfCategory", CategoryType.values());
        return "edit-categories";
}

    @PostMapping("/categories/update/{id}")
    public String updateCategory(@PathVariable Long id, @ModelAttribute Category category) {
        category.setId(id); 
        categoryService.save(category);
        return "redirect:/categories";
    }
}

