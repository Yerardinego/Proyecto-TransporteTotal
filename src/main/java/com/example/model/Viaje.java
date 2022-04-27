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
public class Viaje {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
    
    int id_viaje;
    String origen;
    String destino;
    float costo_viaje;
    
    public Viaje(){
        
    }

    public int getId_viaje() {
        return id_viaje;
    }

    public void setId_viaje(int id_viaje) {
        this.id_viaje = id_viaje;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public float getCosto_viaje() {
        return costo_viaje;
    }

    public void setCosto_viaje(float costo_viaje) {
        this.costo_viaje = costo_viaje;
    }
    
  }
    

