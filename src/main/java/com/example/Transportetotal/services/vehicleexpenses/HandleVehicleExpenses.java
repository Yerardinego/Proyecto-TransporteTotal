package com.example.Transportetotal.services.vehicleexpenses;

import com.example.Transportetotal.model.ExpensesByVehicleId;
import com.example.Transportetotal.repository.ExpensesByVehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HandleVehicleExpenses implements VehicleExpensesHandler {

    private final ExpensesByVehicleRepository repository;
    @Override
    public String delete(Long vehicleId, Long expenseId) {
        try {
            repository.deleteById(new ExpensesByVehicleId(expenseId, vehicleId));
            return "Successfully deleted the registry";
        } catch (Exception e) {
            return "Could not delete the registry";
        }
    }
}
