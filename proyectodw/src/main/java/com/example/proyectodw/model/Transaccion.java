package com.example.proyectodw.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Transaccion{
    @Id
    @GeneratedValue
    long ID;
    int tid;
    int precioTotal;
    @ManyToOne
    Usuario usuario;

    public Transaccion() {
    }

    public Transaccion(int tid, int precioTotal, Usuario usuario) {
        this.tid = tid;
        this.precioTotal = precioTotal;
        this.usuario = usuario;
    }

    public long getID() {
        return ID;
    }


    public int getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(int precioTotal) {
        this.precioTotal = precioTotal;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    

}
