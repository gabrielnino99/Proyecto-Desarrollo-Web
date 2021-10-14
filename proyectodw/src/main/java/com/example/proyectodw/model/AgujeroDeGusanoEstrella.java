package com.example.proyectodw.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class AgujeroDeGusanoEstrella {
    @Id
    @GeneratedValue
    long ID;
    @ManyToOne
    AgujeroDeGusano agujeroDeGusano;
    @ManyToOne
    Estrella estrella;

    public AgujeroDeGusanoEstrella() {
    }

    public AgujeroDeGusanoEstrella(AgujeroDeGusano agujeroDeGusano, Estrella estrella) {
        this.agujeroDeGusano = agujeroDeGusano;
        this.estrella = estrella;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public AgujeroDeGusano getAgujeroDeGusano() {
        return agujeroDeGusano;
    }

    public void setAgujeroDeGusano(AgujeroDeGusano agujeroDeGusano) {
        this.agujeroDeGusano = agujeroDeGusano;
    }

    public Estrella getEstrella() {
        return estrella;
    }

    public void setEstrella(Estrella estrella) {
        this.estrella = estrella;
    }



}
