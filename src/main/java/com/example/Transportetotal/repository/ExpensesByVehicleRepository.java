package com.example.Transportetotal.repository;

import com.example.Transportetotal.model.Expense;
import com.example.Transportetotal.model.ExpensesByVehicle;
import com.example.Transportetotal.model.ExpensesByVehicleId;
import com.example.Transportetotal.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ExpensesByVehicleRepository extends JpaRepository<ExpensesByVehicle, ExpensesByVehicleId> {

    @Query("select ebv from ExpensesByVehicle ebv where ebv.id.vehicleId = :id")
    List<ExpensesByVehicle> findAllByVehicleId(Long id);
}