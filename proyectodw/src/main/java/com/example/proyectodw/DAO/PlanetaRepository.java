package com.example.proyectodw.DAO;

import com.example.proyectodw.model.Planeta;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanetaRepository extends CrudRepository<Planeta, Long>{
    Planeta findByPlid(int plid);
}