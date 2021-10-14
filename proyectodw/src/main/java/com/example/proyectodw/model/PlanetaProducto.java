package com.example.proyectodw.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class PlanetaProducto {
    @Id
    @GeneratedValue
    Long ID;
    @ManyToOne
    Planeta planeta;
    @ManyToOne
    Producto producto;

    public PlanetaProducto() {
    }

    public PlanetaProducto(Planeta planeta, Producto producto) {
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


}
