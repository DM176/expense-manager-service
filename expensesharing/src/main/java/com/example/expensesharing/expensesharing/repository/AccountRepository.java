package com.example.expensesharing.expensesharing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.expensesharing.expensesharing.dto.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {}
