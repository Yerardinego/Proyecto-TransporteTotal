package com.example.Transportetotal.repository;

import com.example.Transportetotal.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    Optional<Expense> findByExpenseCode(String expenseCode);
}