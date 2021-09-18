package com.example.proyectodw.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstrellaRepository extends CrudRepository<Estrella, Long>{
    Estrella findByEid(int eid);
}