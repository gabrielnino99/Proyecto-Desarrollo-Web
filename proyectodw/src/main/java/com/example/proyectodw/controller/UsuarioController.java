package com.example.proyectodw.controller;

import com.example.proyectodw.DAO.UsuarioRepository;
import com.example.proyectodw.services.UsuarioService;

import java.util.List;

import com.example.proyectodw.model.Usuario;
import com.example.proyectodw.model.Nave;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/addUsuario")
    @CrossOrigin(origins = "http://localhost:4200")
    public Usuario addUsuario(@RequestBody Usuario usuario) {
        return usuarioService.crearUsuario(usuario);
    }

    @PostMapping("/addUsuarios")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Usuario> addUsuarios(@RequestBody List<Usuario> usuarios){
        return usuarioService.crearUsuarios(usuarios);
    }

    @GetMapping("/usuario/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Usuario getUsuarioById(@PathVariable Long id){
        return usuarioService.getUsuarioById(id);
    }

    @GetMapping("/usuario/{id}/nave")
    @CrossOrigin(origins = "http://localhost:4200")
    public Nave getNaveUsuarioById(@PathVariable Long id){
        return usuarioService.getNaveUsuarioById(id);
    }

    @GetMapping("/usuarios")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Usuario> getAllUsuarios(){
        return usuarioService.getUsuarios();
    }

    @PutMapping("/updateUsuario")
    @CrossOrigin(origins = "http://localhost:4200")
    public Usuario updateUsuario(@RequestBody Usuario usuario){
        return usuarioService.updateUsuario(usuario);
    }

    @DeleteMapping("/usuario/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public String deleteUsuario(@PathVariable Long id){
        return usuarioService.deleteUsuarioById(id);
    }

}
