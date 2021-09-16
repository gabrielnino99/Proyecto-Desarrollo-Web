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
    int ID;
    @ManyToMany(mappedBy="agujerosDeGusano")
    List<Estrella> estrellas = new ArrayList<>();

    public AgujeroDeGusano() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public List<Estrella> getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(List<Estrella> estrellas) {
        this.estrellas = estrellas;
    }

    

}