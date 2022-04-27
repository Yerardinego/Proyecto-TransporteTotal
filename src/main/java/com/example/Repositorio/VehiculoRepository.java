/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Repositorio;

import com.example.model.Vehiculo;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author yeral
 */

@Repository
////crear, leer, aliminar de la tabla Vehiculo
public interface VehiculoRepository extends CrudRepository<Vehiculo, Long>{

    @Override
    public void deleteById(Long id);

    @Override
    public long count();

    @Override
    public List<Vehiculo> findAll();

    @Override
    public Optional<Vehiculo> findById(Long id);

    @Override
    public <V extends Vehiculo> V save(V entity);
    
}
