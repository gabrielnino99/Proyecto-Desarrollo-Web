package com.example.proyectodw.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Planeta {
    @Id
    @GeneratedValue
    Long ID;
    int plid;
    String nombre;
    @ManyToOne
    @JsonIgnore
    Estrella estrella;
    @OneToMany(mappedBy="planeta")
    @JsonIgnore
    List<PlanetaProducto> productos;

    public Planeta() {
        this.productos = new ArrayList<>();
    }

    public Planeta(String nombre, int plid,Estrella estrella) {
        this.nombre = nombre;
        this.plid = plid;
        this.estrella = estrella;
        this.productos = new ArrayList<>();
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

    public Estrella getEstrella() {
        return estrella;
    }

    public void setEstrella(Estrella estrella) {
        this.estrella = estrella;
    }

    public List<PlanetaProducto> getProductos() {
        return productos;
    }

    public void setProductos(List<PlanetaProducto> productos) {
        this.productos = productos;
    }

    public int getPlid() {
        return plid;
    }

    public void setPlid(int plid) {
        this.plid = plid;
    }

    

}
