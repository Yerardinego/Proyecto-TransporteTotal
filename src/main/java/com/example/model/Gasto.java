/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.model;

/**
 *
 * @author yeral
 */
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Gasto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id_gasto;
    int id_vehiculo;
    float peajes;
    float combustible;
    float reaparaciones_imprevistos;
    
    public Gasto(){
        
    }

    public int getId_gasto() {
        return id_gasto;
    }

    public void setId_gasto(int id_gasto) {
        this.id_gasto = id_gasto;
    }

    public int getId_vehiculo() {
        return id_vehiculo;
    }

    public void setId_vehiculo(int id_vehiculo) {
        this.id_vehiculo = id_vehiculo;
    }

    public float getPeajes() {
        return peajes;
    }

    public void setPeajes(float peajes) {
        this.peajes = peajes;
    }

    public float getCombustible() {
        return combustible;
    }

    public void setCombustible(float combustible) {
        this.combustible = combustible;
    }

    public float getReaparaciones_imprevistos() {
        return reaparaciones_imprevistos;
    }

    public void setReaparaciones_imprevistos(float reaparaciones_imprevistos) {
        this.reaparaciones_imprevistos = reaparaciones_imprevistos;
    }
    
    

}
