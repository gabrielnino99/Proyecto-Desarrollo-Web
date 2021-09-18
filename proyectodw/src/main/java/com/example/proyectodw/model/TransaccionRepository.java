package com.example.proyectodw.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransaccionRepository extends CrudRepository<Transaccion, Long>{
    Transaccion findByTid(int tid);
}
