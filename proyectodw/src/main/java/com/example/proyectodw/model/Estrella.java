package com.example.proyectodw.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Estrella{
    @Id
    @GeneratedValue
    Long ID;
    String nombre;
    int coordenadaX;
    int coordenadaY;
    int coordenadaZ;
    int eid;
    @OneToMany(mappedBy="estrella")
    @JsonIgnore
    List<AgujeroDeGusanoEstrella> agujerosDeGusano;
    @OneToMany(mappedBy="estrella")
    @JsonIgnore
    List<Nave> naves;
    @OneToMany(mappedBy="estrella")
    @JsonIgnore
    List<Planeta> planetas;

    public Estrella() {
        this.agujerosDeGusano = new ArrayList<>();
        this.naves = new ArrayList<>();
        this.planetas =  new ArrayList<>();
    }

    public Estrella(String nombre, int coordenadaX, int coordenadaY, int coordenadaZ, int eid) {
        this.nombre = nombre;
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
        this.coordenadaZ = coordenadaZ;
        this.eid = eid;
        this.agujerosDeGusano = new ArrayList<>();
        this.naves = new ArrayList<>();
        planetas =  new ArrayList<>();
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

    public int getCoordenadaX() {
        return coordenadaX;
    }

    public void setCoordenadaX(int coordenadaX) {
        this.coordenadaX = coordenadaX;
    }

    public int getCoordenadaY() {
        return coordenadaY;
    }

    public void setCoordenadaY(int coordenadaY) {
        this.coordenadaY = coordenadaY;
    }

    public int getCoordenadaZ() {
        return coordenadaZ;
    }

    public void setCoordenadaZ(int coordenadaZ) {
        this.coordenadaZ = coordenadaZ;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public List<AgujeroDeGusanoEstrella> getAgujerosDeGusano() {
        return agujerosDeGusano;
    }

    public void setAgujerosDeGusano(List<AgujeroDeGusanoEstrella> agujerosDeGusano) {
        this.agujerosDeGusano = agujerosDeGusano;
    }

    public List<Nave> getNaves() {
        return naves;
    }

    public void setNaves(List<Nave> naves) {
        this.naves = naves;
    }

    public List<Planeta> getPlanetas() {
        return planetas;
    }

    public void setPlanetas(List<Planeta> planetas) {
        this.planetas = planetas;
    }



}