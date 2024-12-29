package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowRepository extends JpaRepository<Borrowing, Long> {
    // Custom query methods can be added here
}

