package com.example.expensesharing.expensesharing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.expensesharing.expensesharing.dto.Expense;
import com.example.expensesharing.expensesharing.service.ExpenseService;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    // Get a list of all expenses
    @GetMapping("/")
    public ResponseEntity<List<Expense>> listExpenses() {
        List<Expense> expenses = expenseService.getAllExpenses();
        return ResponseEntity.ok(expenses);
    }

    // Add a new expense
    @PostMapping("/")
    public ResponseEntity<String> addExpense(@RequestBody Expense expense) {
        return expenseService.addExpense(expense);
    }

    // Get details of a specific expense by ID
    @GetMapping("/{id}/")
    // @Secured("ROLE_USER")
    public ResponseEntity<Expense> getExpense(@PathVariable Long id) {
        Expense expense = expenseService.getExpenseById(id);
        if (expense != null) {
            return ResponseEntity.ok(expense);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Update an existing expense by ID
    @PutMapping("/{id}/")
    public ResponseEntity<String> updateExpense(@PathVariable Long id, @RequestBody Expense expense) {
        if (expenseService.updateExpense(id, expense)) {
            return ResponseEntity.ok("Expense updated successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete an expense by ID
    @DeleteMapping("/{id}/")
    public ResponseEntity<String> deleteExpense(@PathVariable Long id) {
        expenseService.deleteExpense(id);
        return ResponseEntity.ok("Expense deleted successfully.");

    }
}
