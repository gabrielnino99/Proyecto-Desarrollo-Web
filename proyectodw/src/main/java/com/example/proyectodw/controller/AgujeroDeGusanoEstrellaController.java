package com.example.proyectodw.controller;

import java.util.List;

import com.example.proyectodw.DAO.AgujeroDeGusanoEstrellaRepository;
import com.example.proyectodw.model.AgujeroDeGusanoEstrella;
import com.example.proyectodw.services.AgujeroDeGusanoEstrellaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AgujeroDeGusanoEstrellaController {
    
    @Autowired
    private AgujeroDeGusanoEstrellaService agujeroDeGusanoEstrellaService;

    @PostMapping("/addAgujeroDeGusanoEstrella")
    public AgujeroDeGusanoEstrella addAgujeroDeGusanoEstrella(@RequestBody AgujeroDeGusanoEstrella agujeroDeGusanoEstrella){
        return agujeroDeGusanoEstrellaService.crearAgujeroDeGusanoEstrella(agujeroDeGusanoEstrella);
    }

    @PostMapping("/addAgujerosDeGusanoEstrella")
    public List<AgujeroDeGusanoEstrella> addAgujerosDeGusanoEstrella(@RequestBody List<AgujeroDeGusanoEstrella> agujerosDeGusanoEstrella){
        return agujeroDeGusanoEstrellaService.crearAgujerosDeGusanoEstrella(agujerosDeGusanoEstrella);
    }

    @GetMapping("/agujeroDeGusanoEstrella/{id}")
    public AgujeroDeGusanoEstrella getAgujeroDeGusanoEstrellaById(@PathVariable Long id){
        return agujeroDeGusanoEstrellaService.getAgujeroDeGusanoEstrellaById(id);
    }

    @GetMapping("/agujerosDeGusanoEstrella")
    public List<AgujeroDeGusanoEstrella> getAllAgujerosDeGusanoEstrella(){
        return agujeroDeGusanoEstrellaService.getAgujerosDeGusanoEstrella();
    }

    @PutMapping("/agujeroDeGusanoEstrella")
    public AgujeroDeGusanoEstrella updateAgujeroDeGusanoEstrella(@RequestBody AgujeroDeGusanoEstrella agujeroDeGusanoEstrella){
        return agujeroDeGusanoEstrellaService.updateAgujeroDeGusanoEstrella(agujeroDeGusanoEstrella);
    }

    @DeleteMapping("/agujeroDeGusanoEstrella/{id}")
    public String deleteAgujeroDeGusanoEstrella(@PathVariable Long id){
        return agujeroDeGusanoEstrellaService.deleteAgujeroDeGusanoEstrellaById(id);
    }
}
