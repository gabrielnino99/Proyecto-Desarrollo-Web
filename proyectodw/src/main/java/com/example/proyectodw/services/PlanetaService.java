package com.example.proyectodw.services;

import java.util.List;
import java.util.Optional;

import com.example.proyectodw.DAO.PlanetaRepository;
import com.example.proyectodw.model.Planeta;

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

}
