package com.example.financetrackingproject.Service;

import com.example.financetrackingproject.Model.Transaction;
import com.example.financetrackingproject.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.List;

/*
 * Service class to handle logic fo teh transaction class.
 */
@Service
public class TransactionService {

    @Autowired
    private TransactionRepository repository;

    public List<Transaction> findAll() {
        return repository.findAll();
    }

    public Transaction save(Transaction t) {
        return repository.save(t);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
    public Transaction findById(Long id) {
    return repository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Transaction not found with id: " + id));
    }
    public Transaction update(Long id, Transaction updatedTransaction) {
    Transaction existingTransaction = repository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Transaction not found with id: " + id));
    
    existingTransaction.setAmount(updatedTransaction.getAmount());
    existingTransaction.setCategory(updatedTransaction.getCategory());
    existingTransaction.setDescription(updatedTransaction.getDescription());
    existingTransaction.setTransactionDate(updatedTransaction.getTransactionDate());
    existingTransaction.setReceiptURL(updatedTransaction.getReceiptURL());
    
    return repository.save(existingTransaction);}
    
    
}

