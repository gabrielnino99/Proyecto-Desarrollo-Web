package com.example.proyectodw.services;

import java.util.List;
import java.util.Optional;

import com.example.proyectodw.DAO.AgujeroDeGusanoEstrellaRepository;
import com.example.proyectodw.model.AgujeroDeGusanoEstrella;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgujeroDeGusanoEstrellaService {
    @Autowired
    private AgujeroDeGusanoEstrellaRepository agujeroDeGusanoEstrellaRepository;

    public AgujeroDeGusanoEstrella crearAgujeroDeGusanoEstrella(AgujeroDeGusanoEstrella agujeroDeGusanoEstrella) {
        return agujeroDeGusanoEstrellaRepository.save(agujeroDeGusanoEstrella);
    }

    public List<AgujeroDeGusanoEstrella> crearAgujerosDeGusanoEstrella(
            List<AgujeroDeGusanoEstrella> agujeroDeGusanoEstrella) {
        return (List<AgujeroDeGusanoEstrella>) agujeroDeGusanoEstrellaRepository.saveAll(agujeroDeGusanoEstrella);
    }

    public AgujeroDeGusanoEstrella getAgujeroDeGusanoEstrellaById(Long id) {
        return agujeroDeGusanoEstrellaRepository.findById(id).orElse(null);
    }

    public List<AgujeroDeGusanoEstrella> getAgujerosDeGusanoEstrella() {
        return (List<AgujeroDeGusanoEstrella>) agujeroDeGusanoEstrellaRepository.findAll();
    }

    public AgujeroDeGusanoEstrella updateAgujeroDeGusanoEstrella(AgujeroDeGusanoEstrella agujeroDeGusanoEstrella) {
        Optional<AgujeroDeGusanoEstrella> agujeroDeGusanoEstrellaOpcional = agujeroDeGusanoEstrellaRepository
                .findById(agujeroDeGusanoEstrella.getID());
        AgujeroDeGusanoEstrella agujeroDeGusanoEstrellaEncontrada = null;
        if (agujeroDeGusanoEstrellaOpcional.isPresent()) {

            agujeroDeGusanoEstrellaEncontrada = agujeroDeGusanoEstrellaOpcional.get();
            agujeroDeGusanoEstrellaEncontrada.setAgujeroDeGusano(agujeroDeGusanoEstrella.getAgujeroDeGusano());
            agujeroDeGusanoEstrellaEncontrada.setEstrella(agujeroDeGusanoEstrella.getEstrella());

            agujeroDeGusanoEstrellaRepository.save(agujeroDeGusanoEstrellaEncontrada);
        } else {
            return new AgujeroDeGusanoEstrella();
        }
        return agujeroDeGusanoEstrellaEncontrada;
    }

    public String deleteAgujeroDeGusanoEstrellaById(Long id) {
        agujeroDeGusanoEstrellaRepository.deleteById(id);
        return "Agujero de Gusano Estrella eliminado de manera correcta";
    }

}
