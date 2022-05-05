package com.example.Transportetotal.services.reports.vehicletrips;

import lombok.Value;

@Value
public class TripByVehicleView {
    String vehiclePlate;
    String tripOrigin;
    String tripDestination;
    Double profit;
}
