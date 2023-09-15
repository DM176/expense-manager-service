package com.example.expensesharing.expensesharing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.expensesharing.expensesharing.dto.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    // You can define custom query methods here if needed
    List<Expense> findByDescription(String description);
}
