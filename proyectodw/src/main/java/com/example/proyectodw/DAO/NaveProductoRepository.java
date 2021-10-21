package com.example.proyectodw.DAO;

import com.example.proyectodw.model.NaveProducto;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NaveProductoRepository extends CrudRepository<NaveProducto, Long>{
    
}
