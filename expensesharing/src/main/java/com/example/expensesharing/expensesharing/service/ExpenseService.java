package com.example.expensesharing.expensesharing.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.expensesharing.expensesharing.dto.Account;
import com.example.expensesharing.expensesharing.dto.Expense;
import com.example.expensesharing.expensesharing.repository.ExpenseRepository;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private AccountService accountService;

    // Retrieve all expenses
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    // Retrieve an expense by ID
    public Expense getExpenseById(Long id) {
        Optional<Expense> optionalExpense = expenseRepository.findById(id);
        return optionalExpense.orElse(null);
    }

    // Add a new expense
    public ResponseEntity<String> addExpense(Expense expense) {
        if(expense.getAccount()!=null){
            Long expenseId = expense.getAccount().getAccountId();
            Optional<Account> account = accountService.getAccountById(expenseId);
            if(account.isEmpty()==true){
                return ResponseEntity.ok("Unable to add expense as the specified account does not exists");
            }
        }
        expenseRepository.save(expense);
        return ResponseEntity.ok("Expense added successfully.");
    }

    // Update an existing expense
    public boolean updateExpense(Long id, Expense updatedExpense) {
        Optional<Expense> optionalExpense = expenseRepository.findById(id);
        if (optionalExpense.isPresent()) {
            Expense expense = optionalExpense.get();
            // Update expense properties as needed
            expense.setExpenseName(updatedExpense.getExpenseName());
            expense.setExpenseAmount(updatedExpense.getExpenseAmount());
            expense.setExepenseDescription(updatedExpense.getExepenseDescription());
            expense.setExpenseDate(updatedExpense.getExpenseDate());
            expense.setExpenseCategory(updatedExpense.getExpenseCategory());
            // Add more fields as necessary
            expenseRepository.save(expense);
            return true;
        }
        return false;
    }

    // Delete an expense by ID
    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }
}
