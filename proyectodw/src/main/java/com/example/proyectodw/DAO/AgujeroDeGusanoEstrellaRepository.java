package com.example.proyectodw.DAO;

import com.example.proyectodw.model.AgujeroDeGusanoEstrella;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgujeroDeGusanoEstrellaRepository extends CrudRepository<AgujeroDeGusanoEstrella, Long>{
    
}
