package com.example.proyectodw.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Nave{
    @Id
    @GeneratedValue
    long ID;
    String nombre;
    int carga;
    int velocidad;
    int nid;
    @ManyToOne
    Estrella estrella;
    @OneToMany(mappedBy="nave")
    List<Usuario> usuarios;

    public Nave() {
        this.usuarios = new ArrayList<>();
    }

    public Nave(String nombre, int carga, int velocidad, Estrella estrella, int nid) {
        this.nombre = nombre;
        this.carga = carga;
        this.velocidad = velocidad;
        this.estrella = estrella;
        this.nid = nid;
        this.usuarios = new ArrayList<>();
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

    public int getCarga() {
        return carga;
    }

    public void setCarga(int carga) {
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



}
