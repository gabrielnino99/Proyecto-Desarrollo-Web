package com.example.proyectodw.services;

import java.util.List;
import java.util.Optional;

import com.example.proyectodw.DAO.UsuarioRepository;
import com.example.proyectodw.model.Usuario;

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
        Usuario usuarioExistente = null;
        if (usuarioOpcional.isPresent()) {

            usuarioExistente = usuarioOpcional.get();
            usuarioExistente.setUserName(usuario.getUserName());
            usuarioExistente.setEmail(usuario.getEmail());
            usuarioExistente.setPassword(usuario.getPassword()); // No se si incluir acá:
            usuarioExistente.setRol(usuario.getRol()); // Credito, Transacciones, Rol, Tiempo
            usuarioExistente.setNave(usuario.getNave());
            usuarioExistente.setCredito(usuario.getCredito());
            usuarioExistente.setTiempoDeJuego(usuario.getTiempoDeJuego());
            usuarioRepository.save(usuarioExistente);
        } else {
            return new Usuario();
        }
        return usuarioExistente;
    }

    public String deleteUsuarioById(Long id){
        usuarioRepository.deleteById(id);
        return "Usuario eliminado correctamente";
    }

}
