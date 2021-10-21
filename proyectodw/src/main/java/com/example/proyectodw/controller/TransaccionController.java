package com.example.proyectodw.controller;

import com.example.proyectodw.DAO.TransaccionRepository;
import com.example.proyectodw.services.TransaccionService;

import java.util.List;

import com.example.proyectodw.model.Transaccion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransaccionController {
    
    @Autowired
    private TransaccionService transaccionService;

    @PostMapping("/addTransaccion")
    @CrossOrigin(origins = "http://localhost:4200")
    public Transaccion addTransaccion(@RequestBody Transaccion transaccion) {
        return transaccionService.crearTransaccion(transaccion);
    }

    @PostMapping("/addTransacciones")
    public List<Transaccion> addTransacciones(@RequestBody List<Transaccion> transacciones){
        return transaccionService.crearTransacciones(transacciones);
    }

    @GetMapping("/transaccion/{id}")
    public Transaccion getTransaccionById(@PathVariable Long id){
        return transaccionService.getTransaccionById(id);
    }

    @GetMapping("/transacciones")
    public List<Transaccion> getAllTransacciones(){
        return transaccionService.getTransacciones();
    }

    @PutMapping("/updateTransaccion")
    public Transaccion updateTransaccion(@RequestBody Transaccion transaccion){
        return transaccionService.updateTransaccion(transaccion);
    }

    @DeleteMapping("/transaccion/{id}")
    public String deleteTransaccion(@PathVariable Long id){
        return transaccionService.deleteTransaccionById(id);
    }
}
