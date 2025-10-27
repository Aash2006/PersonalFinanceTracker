package com.example.financetrackingproject.Service;

import com.example.financetrackingproject.Model.Transaction;
import com.example.financetrackingproject.Repository.TransactionRepository;
import org.springframework.stereotype.Service;



import java.util.List;

/*
 * Service class to handle logic fo teh transaction class.
 */
@Service
public class TransactionService {

    
    private final TransactionRepository transactionRepository;


    public TransactionService(TransactionRepository transactionRepository){
        this.transactionRepository = transactionRepository;
    }

    public List<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    public Transaction save(Transaction t) {
        return transactionRepository.save(t);
    }

    public void deleteById(Long id) {
        transactionRepository.deleteById(id);
    }
    public Transaction findById(Long id) {
    return transactionRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Transaction not found with id: " + id));
    }
    public Transaction update(Long id, Transaction updatedTransaction) {
    Transaction existingTransaction = transactionRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Transaction not found with id: " + id));
    
    existingTransaction.setAmount(updatedTransaction.getAmount());
    existingTransaction.setCategory(updatedTransaction.getCategory());
    existingTransaction.setDescription(updatedTransaction.getDescription());
    existingTransaction.setTransactionDate(updatedTransaction.getTransactionDate());
    existingTransaction.setReceiptURL(updatedTransaction.getReceiptURL());
    
    return transactionRepository.save(existingTransaction);}
    
    
}

