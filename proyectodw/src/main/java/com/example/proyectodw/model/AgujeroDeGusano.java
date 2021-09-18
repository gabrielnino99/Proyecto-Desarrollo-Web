package com.example.proyectodw.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class AgujeroDeGusano{
    @Id
    @GeneratedValue
    long ID;
    int aid;
    @ManyToMany(mappedBy="agujerosDeGusano")
    List<Estrella> estrellas;

    public AgujeroDeGusano() {
        estrellas = new ArrayList<>();
    }

    public AgujeroDeGusano(int aid) {
        this.aid = aid;
        estrellas = new ArrayList<>();
    }

    public long getID() {
        return ID;
    }


    public List<Estrella> getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(List<Estrella> estrellas) {
        this.estrellas = estrellas;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    

}