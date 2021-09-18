package com.example.proyectodw.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Planeta{
    @Id
    @GeneratedValue
    long ID;
    int plid;
    String nombre;
    @ManyToOne
    Estrella estrella;
    @ManyToMany
    List<Producto> productos;

    public Planeta() {
        this.productos = new ArrayList<>();
    }

    public Planeta(String nombre, int plid,Estrella estrella) {
        this.nombre = nombre;
        this.plid = plid;
        this.estrella = estrella;
        this.productos = new ArrayList<>();
    }

    public long getID() {
        return ID;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Estrella getEstrella() {
        return estrella;
    }

    public void setEstrella(Estrella estrella) {
        this.estrella = estrella;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public int getPlid() {
        return plid;
    }

    public void setPlid(int plid) {
        this.plid = plid;
    }

    

}
