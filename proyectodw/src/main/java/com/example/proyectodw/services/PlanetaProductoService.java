package com.example.proyectodw.services;

import java.util.List;
import java.util.Optional;

import com.example.proyectodw.DAO.PlanetaProductoRepository;
import com.example.proyectodw.model.PlanetaProducto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanetaProductoService {
    @Autowired
    private PlanetaProductoRepository planetaProductoRepository;

    public PlanetaProducto crearPlanetaProducto(PlanetaProducto planetaProducto) {
        return planetaProductoRepository.save(planetaProducto);
    }

    public List<PlanetaProducto> crearPlanetasProducto(List<PlanetaProducto> planetasProducto) {
        return (List<PlanetaProducto>) planetaProductoRepository.saveAll(planetasProducto);
    }

    public PlanetaProducto getPlanetaProductoById(Long id) {
        return planetaProductoRepository.findById(id).orElse(null);
    }

    public List<PlanetaProducto> getPlanetasProducto() {
        return (List<PlanetaProducto>) planetaProductoRepository.findAll();
    }

    public PlanetaProducto updatePlanetaProducto(PlanetaProducto planetaProducto) {
        Optional<PlanetaProducto> planetaProductoOpcional = planetaProductoRepository.findById(planetaProducto.getID());
        PlanetaProducto planetaProductoEncontrado = null;
        if (planetaProductoOpcional.isPresent()) {
            planetaProductoEncontrado = planetaProductoOpcional.get();
            planetaProductoEncontrado.setFactorDemanda(planetaProducto.getFactorDemanda());
            planetaProductoEncontrado.setStock(planetaProducto.getStock());
            planetaProductoEncontrado.setFactorOferta(planetaProducto.getFactorOferta());
            planetaProductoEncontrado.setPlaneta(planetaProducto.getPlaneta());
            planetaProductoEncontrado.setProducto(planetaProducto.getProducto());

            planetaProductoRepository.save(planetaProductoEncontrado);
        } else {
            return new PlanetaProducto();
        }
        return planetaProductoEncontrado;
    }

    public String deletePlanetaProductoById(Long id) {
        planetaProductoRepository.deleteById(id);
        return "Planeta Producto eliminado de manera correcta";
    }

}
