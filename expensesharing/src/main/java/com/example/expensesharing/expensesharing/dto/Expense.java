package com.example.expensesharing.expensesharing.dto;


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
    private Long id;
    private String name;
    private String description;
    private Double amount;
    private String category;

    @ManyToOne
    @JoinColumn(name = "account_id") // This is the foreign key column in the expenses table
    private User account;
    

    @ManyToOne
    @JoinColumn(name = "payer_id")
    private User payer;

}
