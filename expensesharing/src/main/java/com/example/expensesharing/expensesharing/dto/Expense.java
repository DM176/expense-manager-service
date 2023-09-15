package com.example.expensesharing.expensesharing.dto;


import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "expenses")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long expenseId;
    private String expenseName;
    private String description;
    private Double amount;
    private String category;
	private Date createdDate;

    @ManyToOne // Many expenses can be associated with one user
    @JoinColumn(name = "userId") // Name of the foreign key column
    private Long userId;


}
