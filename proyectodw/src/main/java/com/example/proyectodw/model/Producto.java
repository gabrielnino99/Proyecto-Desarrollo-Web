package com.example.proyectodw.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Producto {
    @Id
    @GeneratedValue
    Long ID;
    int prid;
    String nombre;
    int factorDemanda;
    int stock;
    int factorOferta;
    int column;
    @ManyToMany(mappedBy="productos")
    List<Planeta> planetas;

    public Producto() {
        this.planetas = new ArrayList<>();
    }

    public Producto(String nombre, int prid,int factorDemanda, int stock, int factorOferta, int column) {
        this.nombre = nombre;
        this.prid = prid;
        this.factorDemanda = factorDemanda;
        this.stock = stock;
        this.factorOferta = factorOferta;
        this.column = column;
        this.planetas = new ArrayList<>();
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public List<Planeta> getPlanetas() {
        return planetas;
    }

    public void setPlanetas(List<Planeta> planetas) {
        this.planetas = planetas;
    }

    public int getPrid() {
        return prid;
    }

    public void setPrid(int prid) {
        this.prid = prid;
    }



}
