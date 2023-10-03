package com.example.expensesharing.expensesharing.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.expensesharing.expensesharing.dto.Category;

@Repository
public interface CategoryRepository extends MongoRepository<Category, Long> {}