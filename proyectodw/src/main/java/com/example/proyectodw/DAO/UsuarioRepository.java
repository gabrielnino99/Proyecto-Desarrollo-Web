package com.example.proyectodw.DAO;

import com.example.proyectodw.model.Usuario;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long>{
    Usuario findByUid(int uid);
}
