package com.example.financetrackingproject.Repository;

import com.example.financetrackingproject.Model.Transaction;
import com.example.financetrackingproject.Model.CategoryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query("SELECT SUM(t.amount) FROM Transaction t " +
           "WHERE MONTH(t.transactionDate) = :month " +
           "AND YEAR(t.transactionDate) = :year " +
           "AND t.category.typeOfCategory = :type")
    Double getTotalByCategoryTypeAndMonth(
            @Param("type") CategoryType type,
            @Param("month") int month,
            @Param("year") int year
    );
}
