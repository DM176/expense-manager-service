package com.example.expensesharing.expensesharing.dto;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long expenseId;
    private String expenseName;
    // private String expenseCategory;
    private String exepenseDescription;
    private BigDecimal expenseAmount;
    private Date expenseDate;


    @ManyToOne
    @JoinColumn(name = "accountId") // Specify the column name for the foreign key
    private Account account; // Reference to the associate

    @ManyToOne
    @JoinColumn(name = "categoryId") // Specify the column name for the foreign key
    private Category expenseCategory; 
}
