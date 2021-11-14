package com.example.proyectodw.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class NaveProducto {
    @Id
    @GeneratedValue
    Long ID;
    int cantidad;
    @ManyToOne
    Nave nave;
    @ManyToOne
    Producto producto;

    public NaveProducto() {
    }

    

    public NaveProducto(int cantidad, Nave nave, Producto producto) {
        this.cantidad = cantidad;
        this.nave = nave;
        this.producto = producto;
    }

    public NaveProducto(Long ID, int cantidad, Nave nave, Producto producto) {
        this.ID = ID;
        this.cantidad = cantidad;
        this.nave = nave;
        this.producto = producto;
    }

    

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Nave getNave() {
        return nave;
    }

    public void setNave(Nave nave) {
        this.nave = nave;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    
}
