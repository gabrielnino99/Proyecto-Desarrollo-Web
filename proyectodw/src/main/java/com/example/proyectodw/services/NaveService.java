package com.example.proyectodw.services;

import java.util.List;
import java.util.Optional;

import com.example.proyectodw.DAO.NaveRepository;
import com.example.proyectodw.model.Nave;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NaveService {
    @Autowired
    private NaveRepository naveRepository;

    public Nave crearNave(Nave nave){
        return naveRepository.save(nave);
    }

    public List<Nave> crearNaves(List<Nave> naves){
        return (List<Nave>) naveRepository.saveAll(naves);
    }

    public Nave getNaveById(Long id){
        return naveRepository.findById(id).orElse(null);
    }

    public List<Nave> getNaves(){
        return (List<Nave>) naveRepository.findAll();
    }

    public Nave updateNave(Nave nave){
        Optional<Nave> naveOpcional = naveRepository.findById(nave.getID());
        Nave naveEncontrada = null;
        if(naveOpcional.isPresent()){

            naveEncontrada = naveOpcional.get();
            naveEncontrada.setNombre(nave.getNombre());
            naveEncontrada.setCarga(nave.getCarga());
            naveEncontrada.setUsuarios(nave.getUsuarios());
            naveEncontrada.setVelocidad(nave.getVelocidad());
            naveEncontrada.setEstrella(nave.getEstrella());

            naveRepository.save(naveEncontrada);
        }
        else{
            return new Nave();
        }
        return naveEncontrada;
    }

    public String deleteNaveById(Long id){
        naveRepository.deleteById(id);
        return "Nave eliminada correctamente";
    }

}
