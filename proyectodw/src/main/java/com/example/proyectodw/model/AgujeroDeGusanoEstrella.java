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
    String polo;
    @ManyToOne
    AgujeroDeGusano agujeroDeGusano;
    @ManyToOne
    Estrella estrella;

    public AgujeroDeGusanoEstrella() {
    }

    public AgujeroDeGusanoEstrella(String polo, AgujeroDeGusano agujeroDeGusano, Estrella estrella) {
        this.polo = polo;
        this.agujeroDeGusano = agujeroDeGusano;
        this.estrella = estrella;
    }

    public AgujeroDeGusanoEstrella(long ID, String polo, AgujeroDeGusano agujeroDeGusano, Estrella estrella) {
        this.ID = ID;
        this.polo = polo;
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

    public String getPolo() {
        return polo;
    }

    public void setPolo(String polo) {
        this.polo = polo;
    }



}
