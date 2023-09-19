package com.example.expensesharing.expensesharing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.expensesharing.expensesharing.dto.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {}