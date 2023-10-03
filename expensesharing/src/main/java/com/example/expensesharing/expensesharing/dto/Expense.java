package com.example.expensesharing.expensesharing.dto;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Document(collection= "Expenses")
public class Expense {
    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
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
