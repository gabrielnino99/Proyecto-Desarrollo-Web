package com.example.proyectodw.services;

import java.util.List;
import java.util.Optional;

import com.example.proyectodw.DAO.AgujeroDeGusanoRepository;
import com.example.proyectodw.model.AgujeroDeGusano;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgujeroDeGusanoService {
    @Autowired
    private AgujeroDeGusanoRepository agujeroDeGusanoRepository;

    public AgujeroDeGusano crearAgujeroDeGusano(AgujeroDeGusano agujeroDeGusano){
        return agujeroDeGusanoRepository.save(agujeroDeGusano);
    }

    public List<AgujeroDeGusano> crearAgujerosDeGusano(List<AgujeroDeGusano> agujeroDeGusano){
        return (List<AgujeroDeGusano>) agujeroDeGusanoRepository.saveAll(agujeroDeGusano);
    }

    public AgujeroDeGusano getAgujeroDeGusanoById(Long id){
        return agujeroDeGusanoRepository.findById(id).orElse(null);
    }

    public List<AgujeroDeGusano> getAgujerosDeGusano(){
        return (List<AgujeroDeGusano>) agujeroDeGusanoRepository.findAll();
    }

    public AgujeroDeGusano updateAgujeroDeGusano(AgujeroDeGusano agujeroDeGusano){
        Optional<AgujeroDeGusano> agujeroDeGusanoOpcional = agujeroDeGusanoRepository.findById(agujeroDeGusano.getID());
        AgujeroDeGusano agujeroDeGusanoEncontrada = null;
        if(agujeroDeGusanoOpcional.isPresent()){

            agujeroDeGusanoEncontrada = agujeroDeGusanoOpcional.get();
            agujeroDeGusanoEncontrada.setAid(agujeroDeGusano.getAid());
            agujeroDeGusanoEncontrada.setEstrellas(agujeroDeGusano.getEstrellas());

            agujeroDeGusanoRepository.save(agujeroDeGusanoEncontrada);
        }
        else{
            return new AgujeroDeGusano();
        }
        return agujeroDeGusanoEncontrada;
    }

    public String deleteAgujeroDeGusanoById(Long id){
        agujeroDeGusanoRepository.deleteById(id);
        return "Agujero de Gusano eliminada de manera correcta";
    }

}
