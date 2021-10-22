package com.example.proyectodw.controller;

import java.util.List;

import com.example.proyectodw.DAO.EstrellaRepository;
import com.example.proyectodw.model.AgujeroDeGusanoEstrella;
import com.example.proyectodw.model.Estrella;
import com.example.proyectodw.model.Planeta;
import com.example.proyectodw.services.EstrellaService;

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
    @CrossOrigin(origins = "http://localhost:4200")
    public Estrella getEstrellaById(@PathVariable Long id){
        return estrellaService.getEstrellaById(id);
    }

    @GetMapping("/estrella/{id}/planetas")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Planeta> getPlanetasEstrellaById(@PathVariable Long id){
        return estrellaService.getPlanetasEstrellaById(id);
    }

    @GetMapping("/estrella/{id}/agujerosDeGusano")
    @CrossOrigin(origins = "http://localhost:4200")
    public AgujeroDeGusanoEstrella getAgujeroDeGusanoEstrellaEstrellaById(@PathVariable Long id){
        return estrellaService.getAgujeroDeGusanoEstrellaEstrellaById(id);
    }

    @GetMapping("/estrellas")
    public List<Estrella> getAllEstrellas(){
        return estrellaService.getEstrellas();
    }

    @GetMapping("/estrellasCercanas/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Estrella> getEstrellasCercanasById(@PathVariable Long id){
        return estrellaService.getEstrellasCercanasById(id);
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

