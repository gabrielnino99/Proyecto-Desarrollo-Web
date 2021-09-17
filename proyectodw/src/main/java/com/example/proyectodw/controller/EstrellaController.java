package com.example.proyectodw.controller;

import java.util.List;

import com.example.proyectodw.DAO.EstrellaRepository;
import com.example.proyectodw.model.Estrella;
import com.example.proyectodw.services.EstrellaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/estrella")
public class EstrellaController {
    
    @Autowired
    private EstrellaService estrellaService;

    @PostMapping("/addEstrella")
    public Estrella addEstrella(@RequestBody Estrella estrella){
        return estrellaService.crearEstrella(estrella);
    }

    @PostMapping("/addEstrellas")
    public List<Estrella> addEstrellas(@RequestBody List<Estrella> estrellas){
        return estrellaService.crearEstrellas(estrellas);
    }

    @GetMapping("/estrella/{id}")
    public Estrella getEstrellaById(@PathVariable Long id){
        return estrellaService.getEstrellaById(id);
    }

    @GetMapping("/estrellas")
    public List<Estrella> getAllEstrellas(){
        return estrellaService.getEstrellas();
    }

    @PutMapping("/updateEstrella")
    public Estrella updateEstrella(@RequestBody Estrella estrella){
        return estrellaService.updateEstrella(estrella);
    }

    @DeleteMapping("/estrella/{id}")
    public String deleteEstrella(@PathVariable Long id){
        return estrellaService.deleteEstrellaById(id);
    }
}

