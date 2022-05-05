package com.example.Transportetotal.repository;

import com.example.Transportetotal.model.TripsByVehicle;
import com.example.Transportetotal.model.TripsByVehicleId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TripsByVehicleRepository extends JpaRepository<TripsByVehicle, TripsByVehicleId> {
    List<TripsByVehicle> findTripsByVehiclePlate(String plate);
}