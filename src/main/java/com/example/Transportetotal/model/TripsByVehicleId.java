package com.example.Transportetotal.model;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Embeddable
public class TripsByVehicleId implements Serializable {

    private static final long serialVersionUID = -5033105152214347869L;
    private Long vehicleId;
    private Long tripId;
}
