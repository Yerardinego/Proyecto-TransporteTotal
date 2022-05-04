package com.example.Transportetotal.controller;

import com.example.Transportetotal.services.reports.TripByVehicleView;
import com.example.Transportetotal.services.reports.VehicleTripViewer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("vehicle-trips")
@RequiredArgsConstructor
public class VehicleTripController {

    private final VehicleTripViewer viewer;

    @GetMapping
    public List<TripByVehicleView> findAll() {
        return viewer.display();
    }
}
