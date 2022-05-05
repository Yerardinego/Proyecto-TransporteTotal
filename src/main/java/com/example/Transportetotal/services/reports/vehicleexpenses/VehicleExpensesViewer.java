package com.example.Transportetotal.services.reports.vehicleexpenses;

import java.util.List;

public interface VehicleExpensesViewer {
    List<VehicleExpensesView> display(String plate);
    List<VehicleExpensesView> display();
    List<VehicleExpensesView> display(Long id);
}
