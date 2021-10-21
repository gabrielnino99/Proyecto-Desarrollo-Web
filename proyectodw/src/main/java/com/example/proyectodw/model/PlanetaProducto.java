package com.example.proyectodw.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class PlanetaProducto {
    @Id
    @GeneratedValue
    Long ID;
    int factorDemanda;
    int stock;
    int factorOferta;
    @ManyToOne
    Planeta planeta;
    @ManyToOne
    Producto producto;

    public PlanetaProducto() {
    }

    public PlanetaProducto(int factorDemanda, int stock, int factorOferta, Planeta planeta, Producto producto) {
        this.factorDemanda = factorDemanda;
        this.stock = stock;
        this.factorOferta = factorOferta;
        this.planeta = planeta;
        this.producto = producto;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public Planeta getPlaneta() {
        return planeta;
    }

    public void setPlaneta(Planeta planeta) {
        this.planeta = planeta;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getFactorDemanda() {
        return factorDemanda;
    }

    public void setFactorDemanda(int factorDemanda) {
        this.factorDemanda = factorDemanda;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getFactorOferta() {
        return factorOferta;
    }

    public void setFactorOferta(int factorOferta) {
        this.factorOferta = factorOferta;
    }


}
