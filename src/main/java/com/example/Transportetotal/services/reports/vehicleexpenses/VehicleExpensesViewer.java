package com.example.Transportetotal.services.reports.vehicleexpenses;

import com.example.Transportetotal.services.vehicleexpenses.VehicleExpenseRequest;

import java.util.List;
import java.util.Optional;

public interface VehicleExpensesViewer {
    List<VehicleExpensesView> display(String plate);
    List<VehicleExpensesView> display();
    List<VehicleExpensesView> display(Long id);
    Optional<VehicleExpenseRequest> findById(Long id);
}
