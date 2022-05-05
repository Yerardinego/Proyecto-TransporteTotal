package com.example.Transportetotal.services.vehicleexpenses;

import lombok.Value;

@Value
public class ExpenseRequest {
    String expenseCode;
    Double cost;
}
