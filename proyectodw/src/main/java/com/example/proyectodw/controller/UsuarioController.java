package com.example.proyectodw.controller;

//import com.example.proyectodw.DAO.UsuarioRepository;
import com.example.proyectodw.services.UsuarioService;

import java.util.List;

import com.example.proyectodw.model.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/addUsuario")
    public Usuario addUsuario(@RequestBody Usuario usuario) {
        return usuarioService.crearUsuario(usuario);
    }

    @PostMapping("/addUsuarios")
    public List<Usuario> addUsuarios(@RequestBody List<Usuario> usuarios){
        return usuarioService.crearUsuarios(usuarios);
    }

    @GetMapping("/usuario/{id}")
    public Usuario getUsuarioById(@PathVariable Long id){
        return usuarioService.getUsuarioById(id);
    }

    @GetMapping("/usuarios")
    public List<Usuario> getAllUsuarios(){
        return usuarioService.getUsuarios();
    }

    @PutMapping("/updateUsuaio")
    public Usuario updateUsuario(@RequestBody Usuario usuario){
        return usuarioService.updateUsuario(usuario);
    }

    @DeleteMapping("/usuario/{id}")
    public String deleteUsuario(@PathVariable Long id){
        return usuarioService.deleteUsuarioById(id);
    }

}
