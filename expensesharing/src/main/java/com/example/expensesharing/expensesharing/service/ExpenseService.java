package com.example.expensesharing.expensesharing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.expensesharing.expensesharing.dto.Expense;
import com.example.expensesharing.expensesharing.repository.ExpenseRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    // Retrieve all expenses
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    // Retrieve an expense by ID
    public Optional<Expense> getExpenseById(Long id) {
        return expenseRepository.findById(id);
    }

    // Add a new expense
    public Expense addExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    // Update an existing expense
    public Expense updateExpense(Long id, Expense updatedExpense) {
        Optional<Expense> optionalExpense = expenseRepository.findById(id);
        if (optionalExpense.isPresent()) {
            Expense expense = optionalExpense.get();
            // Update expense properties as needed
            expense.setName(updatedExpense.getName());
            expense.setAmount(updatedExpense.getAmount());
            // Add more fields as necessary
            return expenseRepository.save(expense);
        }
        return null;
    }

    // Delete an expense by ID
    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }
}
