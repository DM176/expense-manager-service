package com.example.expensesharing.expensesharing.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public ResponseEntity<List<Expense>> listExpenses(@RequestParam Long userId) {
        List<Expense> expenses = expenseService.getAllExpensesOfUser(userId);

        if (expenses.isEmpty()) {
            return ResponseEntity.noContent().build(); // Return 204 No Content if no expenses are found
        }

        return ResponseEntity.ok(expenses);
    }

    // Add a new expense
     @PostMapping("/add")
    public ResponseEntity<String> addExpense(@RequestBody Expense expenseDTO, @RequestParam Long userId) {
        expenseService.addExpense(expenseDTO, userId);
        return ResponseEntity.ok("Expense added successfully.");
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

    @GetMapping("/expenses/date}")
    public void deleteExpense(@RequestParam Long userId, @RequestParam Date startDate, @RequestParam Date endDate) {
        expenseService.filterExpenseByDate(userId, startDate, endDate);
    }

}
