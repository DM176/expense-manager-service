package com.example.expensesharing.expensesharing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.expensesharing.expensesharing.service.ExpenseService;
import com.example.expensesharing.expensesharing.dto.Expense;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    // Get a list of all expenses
    @GetMapping("/")
    public List<Expense> listExpenses() {
        return expenseService.getAllExpenses();
    }

    // Add a new expense
    @PostMapping("/add")
    public Expense addExpense(@RequestBody Expense expense) {
        return expenseService.addExpense(expense);
    }

    // Get details of a specific expense by ID
    @GetMapping("/{id}")
    public Optional<Expense> getExpense(@PathVariable Long id) {
        return expenseService.getExpenseById(id);
    }

    // Update an existing expense by ID
    @PutMapping("/{id}")
    public Expense updateExpense(@PathVariable Long id, @RequestBody Expense expense) {
        return expenseService.updateExpense(id, expense);
    }

    // Delete an expense by ID
    @DeleteMapping("/{id}")
    public void deleteExpense(@PathVariable Long id) {
        expenseService.deleteExpense(id);
    }
}
