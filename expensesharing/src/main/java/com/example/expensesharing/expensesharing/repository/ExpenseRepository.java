package com.example.expensesharing.expensesharing.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.expensesharing.expensesharing.dto.Expense;

public interface ExpenseRepository extends MongoRepository<Expense, Long> {
    // You can define custom query methods here if needed
    List<Expense> findByExpenseName(String expenseName);

}
