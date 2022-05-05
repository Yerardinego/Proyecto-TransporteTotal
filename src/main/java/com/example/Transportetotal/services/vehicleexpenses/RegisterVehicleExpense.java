package com.example.Transportetotal.services.vehicleexpenses;

import com.example.Transportetotal.model.Expense;
import com.example.Transportetotal.model.ExpensesByVehicle;
import com.example.Transportetotal.model.ExpensesByVehicleId;
import com.example.Transportetotal.model.Vehicle;
import com.example.Transportetotal.repository.ExpenseRepository;
import com.example.Transportetotal.repository.ExpensesByVehicleRepository;
import com.example.Transportetotal.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class RegisterVehicleExpense implements VehicleExpenseCreator {
    private final VehicleRepository vehicleRepository;
    private final ExpenseRepository expenseRepository;
    private final ExpensesByVehicleRepository expensesByVehicleRepository;

    @Override
    public String create(VehicleExpenseRequest request) {
        try {
            var plate = request.getVehicle().getPlate();
            if (vehicleRepository.existsByPlate(plate))
                return "Vehicle with plate " + plate + " already exists";

            var newVehicle = vehicleRepository.save(toModel(request.getVehicle()));
            expensesByVehicleRepository.saveAll(toModel(request.getExpenses(), newVehicle));
            return "Successfully saved vehicle with expenses and id " + newVehicle.getId();

        } catch (Exception e) {
            return processUnsuccessfulOperation(e);
        }
    }

    private String processUnsuccessfulOperation(Exception exception) {
        exception.printStackTrace();
        return "Could not process operation.";
    }

    @Override
    public String update(VehicleExpenseRequest request, Long id) {
        try {
            var expensesByVehicle = expensesByVehicleRepository.findAllByVehicleId(id);
            if (expensesByVehicle.isEmpty())
                return "No expenses found for vehicle with id " + id;
            return updateVehicle(expensesByVehicle, request);

        } catch (Exception e) {
            return processUnsuccessfulOperation(e);
        }
    }

    private String updateVehicle(List<ExpensesByVehicle> expensesByVehicles, VehicleExpenseRequest request) {

        var vehicle = expensesByVehicles.get(0).getVehicle();
        var vehicleRequest = request.getVehicle();
        expensesByVehicleRepository.deleteAll(expensesByVehicles);

//        Update vehicle fields
        vehicle.setPlate(vehicleRequest.getPlate());
        vehicle.setModel(vehicleRequest.getModel());
        vehicle.setType(vehicleRequest.getType());
        var updatedVehicle = vehicleRepository.save(vehicle);

        var expensesByVehicle = toModel(request.getExpenses(), updatedVehicle);
        expensesByVehicleRepository.saveAll(expensesByVehicle);
        return "Successfully saved vehicle with expenses.";
    }

    private Vehicle toModel(VehicleRequest request) {
        return new Vehicle(
                request.getPlate(),
                request.getType(),
                request.getModel()
        );
    }

    private List<ExpensesByVehicle> toModel(List<ExpenseRequest> expenseRequests, Vehicle vehicle) {
        return expenseRequests
                .stream()
                .map(expenseRequest -> expenseRepository
                        .findByExpenseCode(expenseRequest.getExpenseCode())
                        .map(expense -> toModel(expense, vehicle, expenseRequest.getCost()))
                )
                .flatMap(Optional::stream)
                .collect(Collectors.toList());
    }

    private ExpensesByVehicle toModel(Expense expense, Vehicle vehicle, Double cost) {
        var id = new ExpensesByVehicleId(expense.getId(), vehicle.getId());
        return new ExpensesByVehicle(
                id,
                expense,
                vehicle,
                cost);
    }


}
