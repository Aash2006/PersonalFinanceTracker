package com.example.financetrackingproject.Service;

import com.example.financetrackingproject.Model.Category;

import com.example.financetrackingproject.Repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;


/*
 * Service class, handles most of the logic for the Controller class.
 */
@Service
public class CategoryService {

    
    private CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public List<Category> findAll() {
        return repository.findAll();
    }

    public Category save(Category t) {
        return repository.save(t);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
    public Category findById(Long id) {
    return repository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Category not found with id: " + id));
}

    
}
