package com.example.Transportetotal.controller;

import com.example.Transportetotal.services.reports.vehicleexpenses.VehicleExpensesView;
import com.example.Transportetotal.services.reports.vehicleexpenses.VehicleExpensesViewer;
import com.example.Transportetotal.services.vehicleexpenses.VehicleExpenseCreator;
import com.example.Transportetotal.services.vehicleexpenses.VehicleExpenseRequest;
import com.example.Transportetotal.services.vehicleexpenses.VehicleExpensesHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("vehicle-expenses")
@RequiredArgsConstructor
public class VehicleExpenseController {
    private final VehicleExpenseCreator vehicleExpenseCreator;
    private final VehicleExpensesViewer vehicleExpensesViewer;
    private final VehicleExpensesHandler handler;

    @PostMapping
    public ResponseEntity<String> saveVehicleExpense(@RequestBody VehicleExpenseRequest request) {
        return ResponseEntity.ok(vehicleExpenseCreator.create(request));
    }

    @DeleteMapping("/{vehicleId}/{expenseId}")
    public ResponseEntity<String> delete(@PathVariable Long vehicleId, @PathVariable Long expenseId) {
        return ResponseEntity.ok(handler.delete(vehicleId, expenseId));
    }

    @PutMapping("{id}")
    public ResponseEntity<String> updateVehicleExpense(
            @RequestBody VehicleExpenseRequest request,
            @PathVariable Long id) {
        return ResponseEntity.ok(vehicleExpenseCreator.update(request, id));
    }

    @GetMapping
    public List<VehicleExpensesView> findAll(@RequestParam(required = false) String plate) {
        return Optional
                .ofNullable(plate)
                .map(vehicleExpensesViewer::display)
                .orElseGet(vehicleExpensesViewer::display);
    }

    @GetMapping("{id}")
    public ResponseEntity<List<VehicleExpensesView>> findById(@PathVariable Long id) {
        var vehicleExpensesViews = vehicleExpensesViewer.display(id);
        return vehicleExpensesViews.isEmpty()
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(vehicleExpensesViews);
    }
}
