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
public class Carga {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id_carga;
    String naturaleza;
    float peso_tonelada;
    float volumen;
    public Carga(){
        
    }

    public int getId_carga() {
        return id_carga;
    }

    public void setId_carga(int id_carga) {
        this.id_carga = id_carga;
    }

    public String getNaturaleza() {
        return naturaleza;
    }

    public void setNaturaleza(String naturaleza) {
        this.naturaleza = naturaleza;
    }

    public float getPeso_tonelada() {
        return peso_tonelada;
    }

    public void setPeso_tonelada(float peso_tonelada) {
        this.peso_tonelada = peso_tonelada;
    }

    public float getVolumen() {
        return volumen;
    }

    public void setVolumen(float volumen) {
        this.volumen = volumen;
    }
    

}
