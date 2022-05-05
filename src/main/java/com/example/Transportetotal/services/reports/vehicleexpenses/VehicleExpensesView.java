package com.example.Transportetotal.services.reports.vehicleexpenses;

import com.example.Transportetotal.model.Expense;
import com.example.Transportetotal.model.Vehicle;
import lombok.Value;

import java.util.List;

@Value
public class VehicleExpensesView {

    VehicleView vehicle;
    ExpenseView expense;

    @Value
    static class VehicleView {
        Long id;
        String plate;
        String model;
        String type;

        public VehicleView(Vehicle vehicle) {
            this.id = vehicle.getId();
            this.plate = vehicle.getPlate();
            this.model = vehicle.getModel();
            this.type = vehicle.getType();
        }
    }

    @Value
    static class ExpenseView {
        Long id;
        String name;
        Double cost;

        public ExpenseView(Expense expense, Double cost) {
            this.id = expense.getId();
            this.name = expense.getName();
            this.cost = cost;
        }
    }


}
