package com.example.proyectodw.DAO;

import com.example.proyectodw.model.Transaccion;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransaccionRepository extends CrudRepository<Transaccion, Long>{
    Transaccion findByTid(int tid);
}
