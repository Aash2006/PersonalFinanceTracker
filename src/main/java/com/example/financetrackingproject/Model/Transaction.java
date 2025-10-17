package com.example.financetrackingproject.Model;

import jakarta.persistence.*;
import java.time.LocalDate;
import jakarta.validation.constraints.NotNull;


@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //Primary key

    @NotNull
    @Column(nullable = false)
    private double amount;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
    
    
    private String description;
    private LocalDate transactionDate;
    private String receiptURL;

    // Getters and setters
    public Long getId() { 
        return id; 
    }
    public void setId(Long id) {
        this.id = id; 
    }

    public double getAmount() { 
        return amount; 
    }

    public void setAmount(double amount) { 
        this.amount = amount; 
    }

    public Category getCategory() { 
        return category; 
    }
    
    public void setCategory(Category category) { 
        this.category = category; 
    }

    public String getDescription() { 
        return description; 
    }

    public void setDescription(String description) { 
        this.description = description; 
    }

    public LocalDate getTransactionDate() { 
        return transactionDate; 
    }

    public void setTransactionDate(LocalDate transactionDate) { 
        this.transactionDate = transactionDate; 
    }

    public String getReceiptURL() { 
        return receiptURL; 
    }

    public void setReceiptURL(String receiptURL) { 
        this.receiptURL = receiptURL; 
    }
}





