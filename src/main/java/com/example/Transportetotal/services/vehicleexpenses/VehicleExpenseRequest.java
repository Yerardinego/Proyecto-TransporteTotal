package com.example.Transportetotal.services.vehicleexpenses;

import lombok.Value;

import java.util.List;
import java.util.Map;

@Value
public class VehicleExpenseRequest {
    VehicleRequest vehicle;
//   List containing expense codes such as "M", "C", "P" and its associated cost with the current vehicle
    List<ExpenseRequest> expenses;

}
