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
@Getter
@Setter
@ToString
@Table(name = "trips")
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String tripCode;
    private String source;
    private String destination;
    private Double price;

    @OneToMany(mappedBy = "trip")
    @ToString.Exclude
    private Set<TripsByVehicle> tripsByVehicles;
  }
    

