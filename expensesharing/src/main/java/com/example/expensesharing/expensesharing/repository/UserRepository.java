package com.example.expensesharing.expensesharing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.expensesharing.expensesharing.dto.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
}
