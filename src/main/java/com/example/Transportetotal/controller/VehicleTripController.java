package com.example.Transportetotal.controller;

import com.example.Transportetotal.services.reports.vehicletrips.TripByVehicleView;
import com.example.Transportetotal.services.reports.vehicletrips.VehicleTripViewer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("vehicle-trips")
@RequiredArgsConstructor
public class VehicleTripController {

    private final VehicleTripViewer viewer;

    @GetMapping
    public List<TripByVehicleView> findAll(@RequestParam(required = false) String plate) {
        return Optional
                .ofNullable(plate)
                .map(viewer::display)
                .orElseGet(viewer::display);

    }
}
