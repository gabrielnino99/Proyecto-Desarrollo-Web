package com.example.proyectodw.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Producto {
    @Id
    @GeneratedValue
    Long ID;
    int prid;
    String nombre;
    int column;
    double metros3; 
    @OneToMany(mappedBy="producto")
    @JsonIgnore
    List<PlanetaProducto> planetas;
    @OneToMany(mappedBy="producto")
    @JsonIgnore
    List<NaveProducto> naves;

    public Producto() {
        this.planetas = new ArrayList<>();
        this.naves = new ArrayList<>();
    }

    public Producto(String nombre, int prid, int column, double metros3) {
        this.nombre = nombre;
        this.prid = prid;
        this.column = column;
        this.metros3 = metros3;
        this.planetas = new ArrayList<>();
        this.naves = new ArrayList<>();
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


    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public List<PlanetaProducto> getPlanetas() {
        return planetas;
    }

    public void setPlanetas(List<PlanetaProducto> planetas) {
        this.planetas = planetas;
    }

    public int getPrid() {
        return prid;
    }

    public void setPrid(int prid) {
        this.prid = prid;
    }

    public double getMetros3() {
        return metros3;
    }

    public void setMetros3(double metros3) {
        this.metros3 = metros3;
    }

    public List<NaveProducto> getNaves() {
        return naves;
    }

    public void setNaves(List<NaveProducto> naves) {
        this.naves = naves;
    }



}
