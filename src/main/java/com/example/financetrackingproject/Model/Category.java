package com.example.financetrackingproject.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;//Primary Key

    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "type_of_category")
    private CategoryType typeOfCategory;

    private Double budgetLimit;

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { 
        return name; 
    }

    public void setName(String name) { 
        this.name = name; 
    }

    public CategoryType getTypeOfCategory() {
        return typeOfCategory;
    }

    public void setTypeOfCategory(CategoryType type) {
        this.typeOfCategory = type;
    }

    public Double getBudgetLimit() { 
        return budgetLimit; 
    }

    public void setBudgetLimit(Double budgetLimit) { 
        this.budgetLimit = budgetLimit; 
    }
}
