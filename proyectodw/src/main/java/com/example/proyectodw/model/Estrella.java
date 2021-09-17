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
    int column;
    @ManyToMany
    List<AgujeroDeGusano> agujerosDeGusano = new ArrayList<>();
    @OneToMany(mappedBy="estrella")
    List<Nave> naves = new ArrayList<>();
    @OneToMany(mappedBy="estrella")
    List<Planeta> planetas =  new ArrayList<>();

    public Estrella() {
    }

    public Estrella(String nombre, int coordenadaX, int coordneadaY, int coordenadaZ, int column) {
        this.nombre = nombre;
        this.coordenadaX = coordenadaX;
        this.coordneadaY = coordneadaY;
        this.coordenadaZ = coordenadaZ;
        this.column = column;
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

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
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