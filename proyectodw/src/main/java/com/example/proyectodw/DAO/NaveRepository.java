package com.example.proyectodw.DAO;

import com.example.proyectodw.model.Nave;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NaveRepository extends CrudRepository<Nave, Long>{

}