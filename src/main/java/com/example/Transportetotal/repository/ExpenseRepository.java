package com.example.Transportetotal.repository;

import com.example.Transportetotal.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}