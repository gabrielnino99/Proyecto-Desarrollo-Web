package com.example.proyectodw.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class AgujeroDeGusano{
    @Id
    @GeneratedValue
    long ID;
    int aid;
    @OneToMany(mappedBy="agujeroDeGusano")
    List<AgujeroDeGusanoEstrella> estrellas;

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


    public List<AgujeroDeGusanoEstrella> getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(List<AgujeroDeGusanoEstrella> estrellas) {
        this.estrellas = estrellas;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    

}