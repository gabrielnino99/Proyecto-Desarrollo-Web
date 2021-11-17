package com.example.proyectodw.services;

import java.util.List;
import java.util.Optional;

import com.example.proyectodw.DAO.UsuarioRepository;
import com.example.proyectodw.model.Usuario;
import com.example.proyectodw.model.Nave;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario crearUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario); // Se crea un único usuario
    }

    public List<Usuario> crearUsuarios(List<Usuario> usuarios) {
        return (List<Usuario>) usuarioRepository.saveAll(usuarios); // Se crean varios usuarios
    }

    public Usuario getUsuarioById(Long id) {
        return usuarioRepository.findById(id).orElse(null); // Retorna un usuario según su id
    }

    public List<Usuario> getUsuarios() {
        return (List<Usuario>) usuarioRepository.findAll(); // Retorna todos los usuarios
    }

    public Usuario updateUsuario(Usuario usuario) {
        Optional<Usuario> usuarioOpcional = usuarioRepository.findById(usuario.getID());
        Usuario usuarioEncontrado = null;
        if (usuarioOpcional.isPresent()) {

            usuarioEncontrado = usuarioOpcional.get();
            usuarioEncontrado.setUserName(usuario.getUsername());
            usuarioEncontrado.setEmail(usuario.getEmail());
            usuarioEncontrado.setPassword(usuario.getPassword()); // No se si incluir acá:
            usuarioEncontrado.setRol(usuario.getRol()); // Credito, Transacciones, Rol, Tiempo
            usuarioEncontrado.setNave(usuario.getNave());
            usuarioEncontrado.setCredito(usuario.getCredito());
            usuarioEncontrado.setTiempoDeJuego(usuario.getTiempoDeJuego());
            
            usuarioRepository.save(usuarioEncontrado);
        } else {
            return new Usuario();
        }
        return usuarioEncontrado;
    }

    public String deleteUsuarioById(Long id){
        usuarioRepository.deleteById(id);
        return "Usuario eliminado correctamente";
    }

    public Nave getNaveUsuarioById(Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElse(null); // Retorna la nave del usuario según su id
        if(usuario != null)
            return usuario.getNave();
        else 
            return null;
    }

}
