package com.example.Transportetotal.services.vehicleexpenses;

public interface VehicleExpenseCreator {
    String create(VehicleExpenseRequest request);
    String update(VehicleExpenseRequest request, Long id);
}
