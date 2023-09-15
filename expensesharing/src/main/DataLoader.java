package com.example.expensesharing.expensesharing.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.example.expensesharing.expensesharing.dto.Expense;
import com.example.expensesharing.expensesharing.repository.ExpenseRepository;

import java.math.BigDecimal;
import java.util.Date;

@SpringBootApplication
public class DataLoader implements CommandLineRunner {

    @Autowired
    private final ExpenseRepository expenseRepository;

    @Autowired
    public DataLoader(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Create and save initial Expense data here
        createInitialExpenses();
    }

    private void createInitialExpenses() {
        Expense expense1 = new Expense();
        expense1.setName("Food");
        expense1.setAmount(new BigDecimal("100.00"));
        expense1.setExpenseDate(new Date());

        Expense expense2 = new Expense();
        expense2.setName("Grocerry");
        expense2.setAmount(new BigDecimal("200.00"));
        expense2.setExpenseDate(new Date());

        // Save the expenses to the database
        expenseRepository.save(expense1);
        expenseRepository.save(expense2);

        System.out.println("Initial data loaded.");
    }
}
