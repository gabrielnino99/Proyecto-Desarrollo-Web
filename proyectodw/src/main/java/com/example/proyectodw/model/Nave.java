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
public class Nave{
    @Id
    @GeneratedValue
    Long ID;
    String nombre;
    double carga;
    double cargaMaxima;
    int velocidad;
    int nid;
    @ManyToOne
    Estrella estrella;
    @OneToMany(mappedBy="nave")
    @JsonIgnore
    List<NaveProducto> productos;
    @OneToMany(mappedBy="nave")
    @JsonIgnore
    List<Usuario> usuarios;

    public Nave() {
        this.usuarios = new ArrayList<>();
        this.productos = new ArrayList<>();
    }
    
    public Nave(String nombre, double carga, double cargaMaxima, int velocidad, Estrella estrella, int nid) {
        this.nombre = nombre;
        this.carga = carga;
        this.cargaMaxima = cargaMaxima;
        this.velocidad = velocidad;
        this.estrella = estrella;
        this.nid = nid;
        this.productos = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }

    public Nave(Long ID, String nombre, double carga, double cargaMaxima, int velocidad, int nid, Estrella estrella) {
        this.ID = ID;
        this.nombre = nombre;
        this.carga = carga;
        this.cargaMaxima = cargaMaxima;
        this.velocidad = velocidad;
        this.nid = nid;
        this.estrella = estrella;
        this.usuarios = new ArrayList<>();
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

    public double getCarga() {
        return carga;
    }

    public void setCarga(double carga) {
        this.carga = carga;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public Estrella getEstrella() {
        return estrella;
    }

    public void setEstrella(Estrella estrella) {
        this.estrella = estrella;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public int getNid() {
        return nid;
    }

    public void setNid(int nid) {
        this.nid = nid;
    }

    public double getCargaMaxima() {
        return cargaMaxima;
    }

    public void setCargaMaxima(double cargaMaxima) {
        this.cargaMaxima = cargaMaxima;
    }

    public List<NaveProducto> getProductos() {
        return productos;
    }

    public void setProductos(List<NaveProducto> productos) {
        this.productos = productos;
    }


}
