package com.example.proyectodw.controller;

import java.util.List;

//import com.example.proyectodw.DAO.PlanetaRepository;
import com.example.proyectodw.model.Planeta;
import com.example.proyectodw.services.PlanetaService;

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
public class PlanetaController {
    
    @Autowired
    private PlanetaService planetaService;

    @PostMapping("/addPlaneta")
    public Planeta addProducto(@RequestBody Planeta planeta){
        return planetaService.crearPlaneta(planeta);
    }

    @PostMapping("/addPlanetas")
    public List<Planeta> addPlanetas(@RequestBody List<Planeta> planetas){
        return planetaService.crearPlanetas(planetas);
    }

    @GetMapping("/planeta/{id}")
    public Planeta getPlanetaById(@PathVariable Long id){
        return planetaService.getPlanetaById(id);
    }

    @GetMapping("/planetas")
    public List<Planeta> getAllPlanetas(){
        return planetaService.getPlanetas();
    }

    @PutMapping("/updatePlaneta")
    public Planeta updatePlaneta(@RequestBody Planeta planeta){
        return planetaService.updatePlaneta(planeta);
    }

    @DeleteMapping("/planeta/{id}")
    public String deletePlaneta(@PathVariable Long id){
        return planetaService.deletePlanetaById(id);
    }

}
