package com.example.proyectodw.controller;

import java.util.List;

import com.example.proyectodw.DAO.AgujeroDeGusanoRepository;
import com.example.proyectodw.model.AgujeroDeGusano;
import com.example.proyectodw.services.AgujeroDeGusanoService;

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
public class AgujeroDeGusanoController {
    
    @Autowired
    private AgujeroDeGusanoService agujeroDeGusanoService;

    @PostMapping("/addAgujeroDeGusano")
    public AgujeroDeGusano addAgujeroDeGusano(@RequestBody AgujeroDeGusano agujeroDeGusano){
        return agujeroDeGusanoService.crearAgujeroDeGusano(agujeroDeGusano);
    }

    @PostMapping("/addAgujerosDeGusano")
    public List<AgujeroDeGusano> addAgujerosDeGusano(@RequestBody List<AgujeroDeGusano> agujerosDeGusano){
        return agujeroDeGusanoService.crearAgujerosDeGusano(agujerosDeGusano);
    }

    @GetMapping("/agujeroDeGusano/{id}")
    public AgujeroDeGusano getAgujeroDeGusanoById(@PathVariable Long id){
        return agujeroDeGusanoService.getAgujeroDeGusanoById(id);
    }

    @GetMapping("/agujerosDeGusano")
    public List<AgujeroDeGusano> getAllAgujerosDeGusano(){
        return agujeroDeGusanoService.getAgujerosDeGusano();
    }

    @PutMapping("/agujeroDeGusano")
    public AgujeroDeGusano updateAgujeroDeGusano(@RequestBody AgujeroDeGusano agujeroDeGusano){
        return agujeroDeGusanoService.updateAgujeroDeGusano(agujeroDeGusano);
    }

    @DeleteMapping("/agujeroDeGusano/{id}")
    public String deleteAgujeroDeGusano(@PathVariable Long id){
        return agujeroDeGusanoService.deleteAgujeroDeGusanoById(id);
    }
}