package com.example.proyectodw.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.proyectodw.DAO.EstrellaRepository;
import com.example.proyectodw.model.Estrella;
import com.example.proyectodw.model.Planeta;

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

    public List<Estrella> getEstrellasCercanasById(Long id){
        List<Estrella> estrellasCercanas= new ArrayList<>();
        Estrella estrella = estrellaRepository.findById(id).orElse(null);
        if(estrella != null){
            int eidBase = estrella.getEid();
            int cantMenores = 5;
            int cantMayores = 5;
            if(eidBase >= 0 && eidBase <= 3){
                cantMayores += cantMenores - eidBase;
                cantMenores = eidBase;
            }
            else if(eidBase >=39994 && eidBase <= 39999 ){
                cantMenores += cantMayores - Math.abs(eidBase - 39999);
                cantMayores = Math.abs( eidBase - 39999); 
            }
            int contMin = eidBase;
            for(int i=0;i<cantMenores;i++){
                contMin--;
                Estrella e = estrellaRepository.findByEid(contMin);
                estrellasCercanas.add(e);
            }

            int contMax = eidBase;
            for(int i=0;i<cantMayores;i++){
                contMax++;
                Estrella e = estrellaRepository.findByEid(contMax);
                estrellasCercanas.add(e);
            }
        }
        return estrellasCercanas;
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
            estrellaEncontrada.setCoordenadaY(estrella.getCoordenadaY());
            estrellaEncontrada.setCoordenadaZ(estrella.getCoordenadaZ());
            estrellaEncontrada.setNaves(estrella.getNaves());
            estrellaEncontrada.setPlanetas(estrella.getPlanetas());
            estrellaEncontrada.setAgujerosDeGusano(estrella.getAgujerosDeGusano());

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

    public List<Planeta> getPlanetasEstrellaById(Long id){
        Estrella estrella = estrellaRepository.findById(id).orElse(null);
        if(estrella != null)
            return estrella.getPlanetas();
        else
            return null;
    }

    public List<Estrella> getEstrellasCoordenadaX(int min, int max){
        List<Estrella> estrellas = (List<Estrella>) estrellaRepository.findAll();
        //List<Estrella> estrellasFiltradas = estrellaRepository.;
        //return estrellasFiltradas;
        return estrellas;
    }
}
