package com.example.proyectodw.services;

import java.util.List;
import java.util.Optional;

import com.example.proyectodw.DAO.EstrellaRepository;
import com.example.proyectodw.model.Estrella;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstrellaService {
    @Autowired
    private EstrellaRepository estrellaRepository;

    public Estrella crearEstrella(Estrella estrella){
        return estrellaRepository.save(estrella);
    }

    public List<Estrella> crearEstrellas(List<Estrella> estrellas){
        return (List<Estrella>) estrellaRepository.saveAll(estrellas);
    }

    public Estrella getEstrellaById(Long id){
        return estrellaRepository.findById(id).orElse(null);
    }

    public List<Estrella> getEstrellas(){
        return (List<Estrella>) estrellaRepository.findAll();
    }

    public Estrella updateEstrella(Estrella estrella){
        Optional<Estrella> estrellaOpcional = estrellaRepository.findById(estrella.getID());
        Estrella estrellaEncontrada = null;
        if(estrellaOpcional.isPresent()){

            estrellaEncontrada = estrellaOpcional.get();
            estrellaEncontrada.setNombre(estrella.getNombre());
            estrellaEncontrada.setCoordenadaX(estrella.getCoordenadaX());
            estrellaEncontrada.setCoordneadaY(estrella.getCoordneadaY());
            estrellaEncontrada.setCoordenadaZ(estrella.getCoordenadaZ());
            estrellaEncontrada.setNaves(estrella.getNaves());
            estrellaEncontrada.setPlanetas(estrella.getPlanetas());
            estrellaEncontrada.setAgujerosDeGusano(estrella.getAgujerosDeGusano());
            estrellaEncontrada.setColumn(estrella.getColumn());

            estrellaRepository.save(estrellaEncontrada);
        }
        else{
            return new Estrella();
        }
        return estrellaEncontrada;
    }

    public String deleteEstrellaById(Long id){
        estrellaRepository.deleteById(id);
        return "Estrella eliminada de manera correcta";
    }

}
