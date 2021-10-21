package com.example.proyectodw.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.proyectodw.DAO.PlanetaRepository;
import com.example.proyectodw.model.Planeta;
import com.example.proyectodw.model.PlanetaProducto;
import com.example.proyectodw.model.Producto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanetaService {
    @Autowired
    private PlanetaRepository planetaRepository;

    public Planeta crearPlaneta(Planeta planeta) {
        return planetaRepository.save(planeta);
    }

    public List<Planeta> crearPlanetas(List<Planeta> planetas) {
        return (List<Planeta>) planetaRepository.saveAll(planetas);
    }

    public Planeta getPlanetaById(Long id) {
        return planetaRepository.findById(id).orElse(null);
    }

    public List<Planeta> getPlanetas() {
        return (List<Planeta>) planetaRepository.findAll();
    }

    public Planeta updatePlaneta(Planeta planeta) {
        Optional<Planeta> planetaOpcional = planetaRepository.findById(planeta.getID());
        Planeta planetaEncontrado = null;
        if (planetaOpcional.isPresent()) {

            planetaEncontrado = planetaOpcional.get();
            planetaEncontrado.setNombre(planeta.getNombre());
            planetaEncontrado.setEstrella(planeta.getEstrella());
            planetaEncontrado.setProductos(planeta.getProductos());

            planetaRepository.save(planetaEncontrado);
        } else {
            return new Planeta();
        }
        return planetaEncontrado;
    }

    public String deletePlanetaById(Long id) {
        planetaRepository.deleteById(id);
        return "Planeta eliminado de manera correcta";
    }

    public List<Producto> getProductosPlanetaById(Long id){
        List<Producto> productos = new ArrayList<>();
        Planeta planeta = planetaRepository.findById(id).orElse(null);
        if(planeta != null){
           List<PlanetaProducto> planetaProductos = planeta.getProductos();
           for(PlanetaProducto pp : planetaProductos){
               productos.add(pp.getProducto());
           }
        }
        return productos;
    }

    public List<PlanetaProducto> getProductosPlanetasById(Long id){
        List<PlanetaProducto> planetasProductos = new ArrayList<>();
        Planeta planeta = planetaRepository.findById(id).orElse(null);
        if(planeta != null){
           return planeta.getProductos();
        }
        return planetasProductos;
    }

}
