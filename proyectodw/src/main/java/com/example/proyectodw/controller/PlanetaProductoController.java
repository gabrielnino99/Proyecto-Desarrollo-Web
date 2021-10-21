package com.example.proyectodw.controller;

import java.util.List;

import com.example.proyectodw.DAO.PlanetaProductoRepository;
import com.example.proyectodw.model.PlanetaProducto;
import com.example.proyectodw.services.PlanetaProductoService;

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
public class PlanetaProductoController {
    @Autowired
    private PlanetaProductoService planetaProductoService;

    @PostMapping("/addPlanetaProducto")
    public PlanetaProducto addPlanetaProducto(@RequestBody PlanetaProducto planetaProducto){
        return planetaProductoService.crearPlanetaProducto(planetaProducto);
    }

    @PostMapping("/addPlanetasProducto")
    public List<PlanetaProducto> addPlanetasProducto(@RequestBody List<PlanetaProducto> planetasProducto){
        return planetaProductoService.crearPlanetasProducto(planetasProducto);
    }

    @GetMapping("/planetaProducto/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public PlanetaProducto getPlanetaProductoById(@PathVariable Long id){
        return planetaProductoService.getPlanetaProductoById(id);
    }

    @GetMapping("/planetasProducto")
    public List<PlanetaProducto> getAllPlanetasProducto(){
        return planetaProductoService.getPlanetasProducto();
    }

    @PutMapping("/updatePlanetaProducto")
    @CrossOrigin(origins = "http://localhost:4200")
    public PlanetaProducto updatePlanetaProducto(@RequestBody PlanetaProducto planetaProducto){
        return planetaProductoService.updatePlanetaProducto(planetaProducto);
    }

    @DeleteMapping("/planetaProducto/{id}")
    public String deletePlanetaProducto(@PathVariable Long id){
        return planetaProductoService.deletePlanetaProductoById(id);
    }


}
