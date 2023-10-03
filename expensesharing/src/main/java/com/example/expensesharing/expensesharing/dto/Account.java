package com.example.expensesharing.expensesharing.dto;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection= "Accounts")
public class Account {
    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;
    private String accountName;
    private String accountDescription;

    @Transient
    private static final String SEQUENCE_NAME = "user_sequence";
    // @OneToMany(mappedBy = "account") // One account can have many expenses
    // private List<Expense> expenses; // Reference to the associated Expenses
}
