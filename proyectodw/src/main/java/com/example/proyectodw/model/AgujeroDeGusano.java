package com.example.proyectodw.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class AgujeroDeGusano{
    @Id
    @GeneratedValue
    Long ID;
    int aid;
    @OneToMany(mappedBy="agujeroDeGusano")
    @JsonIgnore
    List<AgujeroDeGusanoEstrella> estrellas;

    public AgujeroDeGusano() {
        estrellas = new ArrayList<>();
    }

    public AgujeroDeGusano(int aid) {
        this.aid = aid;
        estrellas = new ArrayList<>();
    }

    public Long getID() {
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

    public void setID(Long ID) {
        this.ID = ID;
    }

    

}