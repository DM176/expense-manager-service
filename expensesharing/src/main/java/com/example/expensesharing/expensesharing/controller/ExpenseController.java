package com.example.expensesharing.expensesharing.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.example.expensesharing.expensesharing.service.ExpenseService;
import com.example.expensesharing.expensesharing.dto.Expense;

import java.util.List;

@Controller
@RequestMapping("/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    // Display the list of expenses
    @GetMapping("/")
    public ModelAndView listExpenses(Model model) {
        List<Expense> expenses = expenseService.getAllExpenses();
        model.addAttribute("expenses", expenses);
        return new ModelAndView("expenses/list");
    }

    // Show the form for adding a new expense
    @GetMapping("/add")
    public ModelAndView showAddExpenseForm(Model model) {
        model.addAttribute("expense", new Expense());
        return new ModelAndView("expenses/add");
    }

    // Handle the submission of a new expense
    @PostMapping("/add")
    public String addExpense(@ModelAttribute("expense") Expense expense) {
        expenseService.addExpense(expense);
        return "redirect:/expenses/";
    }

    // Show the form for editing an expense
    @GetMapping("/edit/{id}")
    public ModelAndView showEditExpenseForm(@PathVariable Long id, Model model) {
        Expense expense = expenseService.getExpenseById(id);
        model.addAttribute("expense", expense);
        return new ModelAndView("expenses/edit");
    }

    // Handle the submission of an edited expense
    @PostMapping("/edit/{id}")
    public String editExpense(@PathVariable Long id, @ModelAttribute("expense") Expense expense) {
        expenseService.updateExpense(id, expense);
        return "redirect:/expenses/";
    }

    // Delete an expense
    @GetMapping("/delete/{id}")
    public String deleteExpense(@PathVariable Long id) {
        expenseService.deleteExpense(id);
        return "redirect:/expenses/";
    }
}
