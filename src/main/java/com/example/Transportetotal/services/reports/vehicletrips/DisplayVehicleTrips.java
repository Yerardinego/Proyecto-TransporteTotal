package com.example.Transportetotal.services.reports.vehicletrips;

import com.example.Transportetotal.model.*;
import com.example.Transportetotal.repository.ExpensesByVehicleRepository;
import com.example.Transportetotal.repository.TripsByVehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DisplayVehicleTrips implements VehicleTripViewer {

    private final TripsByVehicleRepository repository;
    private final ExpensesByVehicleRepository vehicleExpensesRepository;

    @Override
    public List<TripByVehicleView> display() {
        return repository
                .findAll()
                .stream()
                .map(this::toView)
                .collect(Collectors.toList());
    }

    @Override
    public List<TripByVehicleView> display(String plate) {
        return repository
                .findTripsByVehiclePlate(plate)
                .stream()
                .map(this::toView)
                .collect(Collectors.toList());
    }

    @Override
    public List<TripByVehicleView> display(Long vehicleId) {
        return repository
                .findAll()
                .stream()
                .filter(tripsByVehicle -> tripsByVehicle.getId().getVehicleId().equals(vehicleId))
                .map(this::toView)
                .collect(Collectors.toList());
    }

    private TripByVehicleView toView(TripsByVehicle tripsByVehicle) {
        var vehicle = tripsByVehicle.getVehicle();
        var trip = tripsByVehicle.getTrip();
        return new TripByVehicleView(
                vehicle.getPlate(),
                trip.getSource(),
                trip.getDestination(),
                calculateProfit(vehicle, trip)
        );
    }

    private Double calculateProfit(Vehicle vehicle, Trip trip) {
        var tripPrice = trip.getPrice();
        var totalExpenses = vehicleExpensesRepository
                .findAllByVehicleId(vehicle.getId())
                .stream()
                .map(ExpensesByVehicle::getCost)
                .mapToDouble(Double::doubleValue)
                .sum();
        return tripPrice - totalExpenses;
    }
}
