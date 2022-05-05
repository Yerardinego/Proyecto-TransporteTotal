package com.example.Transportetotal.services.reports.vehicletrips;

import java.util.List;

public interface VehicleTripViewer {
    List<TripByVehicleView> display();
    List<TripByVehicleView> display(String plate);
    List<TripByVehicleView> display(Long vehicleId);
}
