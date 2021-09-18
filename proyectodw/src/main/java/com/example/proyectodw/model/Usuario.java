package com.example.proyectodw.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Usuario{
    @Id
    @GeneratedValue
    long ID;
    int uid;
    String userName;
    String password;
    String rol;
    String email;
    int credito;
    int tiempoDeJuego;
    @ManyToOne
    Nave nave;
    @OneToMany(mappedBy="usuario")
    List<Transaccion> transacciones;

    public Usuario() {
        this.transacciones = new ArrayList<>();
    }

    public Usuario(int uid, String userName, String password, String rol, String email, int credito, int tiempoDeJuego, Nave nave) {
        this.uid = uid;
        this.userName = userName;
        this.password = password;
        this.rol = rol;
        this.email = email;
        this.credito = credito;
        this.tiempoDeJuego = tiempoDeJuego;
        this.nave = nave;
        this.transacciones = new ArrayList<>();
    }

    public long getID() {
        return ID;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCredito() {
        return credito;
    }

    public void setCredito(int credito) {
        this.credito = credito;
    }

    public int getTiempoDeJuego() {
        return tiempoDeJuego;
    }

    public void setTiempoDeJuego(int tiempoDeJuego) {
        this.tiempoDeJuego = tiempoDeJuego;
    }

    public Nave getNave() {
        return nave;
    }

    public void setNave(Nave nave) {
        this.nave = nave;
    }

    public List<Transaccion> getTransacciones() {
        return transacciones;
    }

    public void setTransacciones(List<Transaccion> transacciones) {
        this.transacciones = transacciones;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    

}
