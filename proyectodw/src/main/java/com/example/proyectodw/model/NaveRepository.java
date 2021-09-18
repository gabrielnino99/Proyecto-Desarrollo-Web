package com.example.proyectodw.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NaveRepository extends CrudRepository<Nave, Long>{
    Nave findByNid(int nid);
}