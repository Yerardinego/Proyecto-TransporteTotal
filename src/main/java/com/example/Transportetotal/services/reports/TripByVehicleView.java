package com.example.Transportetotal.services.reports;

import lombok.Value;

@Value
public class TripByVehicleView {
    String vehiclePlate;
    String tripOrigin;
    String tripDestination;
    Double profit;
}
