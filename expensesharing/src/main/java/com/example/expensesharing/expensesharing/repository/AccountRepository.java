package com.example.expensesharing.expensesharing.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.expensesharing.expensesharing.dto.Account;

public interface AccountRepository extends MongoRepository<Account, Long> {}
