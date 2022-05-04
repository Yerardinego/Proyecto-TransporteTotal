package com.example.Transportetotal.repository;

import com.example.Transportetotal.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripRepository extends JpaRepository<Trip, Long> {
}