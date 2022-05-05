/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Transportetotal.repository;

import com.example.Transportetotal.model.Vehicle;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author yeral
 */

////crear, leer, aliminar de la tabla Vehiculo
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    @Override
    void deleteById(Long id);

    @Override
    long count();

    @Override
    List<Vehicle> findAll();

    @Override
    Optional<Vehicle> findById(Long id);

    @Override
    <V extends Vehicle> V save(V entity);

    Optional<Vehicle> findByPlate(String plate);

    boolean existsByPlate(String plate);
}
