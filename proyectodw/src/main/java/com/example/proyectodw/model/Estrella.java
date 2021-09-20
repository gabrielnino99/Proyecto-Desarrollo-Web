package com.example.proyectodw.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Estrella{
    @Id
    @GeneratedValue
    Long ID;
    String nombre;
    int coordenadaX;
    int coordneadaY;
    int coordenadaZ;
    int eid;
    @ManyToMany
    List<AgujeroDeGusano> agujerosDeGusano;
    @OneToMany(mappedBy="estrella")
    List<Nave> naves;
    @OneToMany(mappedBy="estrella")
    List<Planeta> planetas;

    public Estrella() {
        this.agujerosDeGusano = new ArrayList<>();
        this.naves = new ArrayList<>();
        this.planetas =  new ArrayList<>();
    }

    public Estrella(String nombre, int coordenadaX, int coordneadaY, int coordenadaZ, int eid) {
        this.nombre = nombre;
        this.coordenadaX = coordenadaX;
        this.coordneadaY = coordneadaY;
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

    public int getCoordneadaY() {
        return coordneadaY;
    }

    public void setCoordneadaY(int coordneadaY) {
        this.coordneadaY = coordneadaY;
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

    public List<AgujeroDeGusano> getAgujerosDeGusano() {
        return agujerosDeGusano;
    }

    public void setAgujerosDeGusano(List<AgujeroDeGusano> agujerosDeGusano) {
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