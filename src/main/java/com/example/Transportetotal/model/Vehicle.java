/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Transportetotal.model;

/**
 *
 * @author yeral
 */
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@Setter
@Getter
@ToString
@Table(name = "vehicles")
public class Vehicle {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String plate;
    private String type;
    private String model;

    public Vehicle(String plate, String type, String model) {
        this.plate = plate;
        this.type = type;
        this.model = model;
    }

    @OneToMany(mappedBy = "vehicle")
    @ToString.Exclude
    private Set<TripsByVehicle> tripsByVehicles;

    @OneToMany(mappedBy = "vehicle")
    @ToString.Exclude
    private Set<ExpensesByVehicle> expensesByVehicles;
}
