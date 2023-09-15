package com.example.expensesharing.expensesharing.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.expensesharing.expensesharing.dto.Expense;
import com.example.expensesharing.expensesharing.repository.ExpenseRepository;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

 
    // Retrieve all expenses
    public List<Expense> getAllExpensesOfUser(Long userId) {
        return expenseRepository.findByUserId(userId);
    }


    // Retrieve an expense by ID
    public Optional<Expense> getExpenseById(Long id) {
        return expenseRepository.findById(id);
    }

    // Add a new expense
    public Expense addExpense(Expense expense, Long userId) {
        expense.setUserId(userId);
        return expenseRepository.save(expense);
    }

    public Expense updateExpense(Long id, Expense updatedExpense) {
        Optional<Expense> optionalExpense = expenseRepository.findById(id);
        if (optionalExpense.isPresent()) {
            Expense expense = optionalExpense.get();
    
            // Update expense properties as needed
            if (updatedExpense.getExpenseName() != null) {
                expense.setExpenseName(updatedExpense.getExpenseName());
            }
            if (updatedExpense.getAmount() != null) {
                expense.setAmount(updatedExpense.getAmount());
            }
            if (updatedExpense.getDescription() != null) {
                expense.setDescription(updatedExpense.getDescription());
            }
    
            return expenseRepository.save(expense);
        }
        return null;
    }

    // Delete an expense by ID
    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }


    public List<Expense> filterExpenseByDate(Long userId, Date startDate, Date endDate) {
        // Retrieve expenses within the date range and belonging to the specified user
        List<Expense> expenses = expenseRepository.findByUserIdAndCreatedDateBetween(userId, startDate, endDate);

        return expenses;
    }
}
