package com.example.proyectodw.controller;

import java.util.List;

import com.example.proyectodw.DAO.NaveProductoRepository;
import com.example.proyectodw.model.NaveProducto;
import com.example.proyectodw.services.NaveProductoService;

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
public class NaveProductoController {
    @Autowired
    private NaveProductoService naveProductoService;

    @PostMapping("/addNaveProducto")
    @CrossOrigin(origins = "http://localhost:4200")
    public NaveProducto addNaveProducto(@RequestBody NaveProducto naveProducto){
        return naveProductoService.crearNaveProducto(naveProducto);
    }

    @PostMapping("/addNavesProducto")
    public List<NaveProducto> addNavesProducto(@RequestBody List<NaveProducto> navesProducto){
        return naveProductoService.crearNavesProducto(navesProducto);
    }

    @GetMapping("/naveProducto/{id}")
    public NaveProducto getNaveProductoById(@PathVariable Long id){
        return naveProductoService.getNaveProductoById(id);
    }

    @GetMapping("/naveProducto/{nid}/{prid}")
    @CrossOrigin(origins = "http://localhost:4200")
    public NaveProducto getNaveProductoById(@PathVariable Long nid, @PathVariable Long prid){
        return naveProductoService.getNaveProductoDoubleId(nid, prid);
    }

    @GetMapping("/navesProducto")
    public List<NaveProducto> getAllNavesProducto(){
        return naveProductoService.getNavesProducto();
    }

    @PutMapping("/updateNaveProducto")
    @CrossOrigin(origins = "http://localhost:4200")
    public NaveProducto updateNaveProducto(@RequestBody NaveProducto naveProducto){
        return naveProductoService.updateNaveProducto(naveProducto);
    }

    @DeleteMapping("/naveProducto/{id}")
    public String deleteNaveProducto(@PathVariable Long id){
        return naveProductoService.deleteNaveProductoById(id);
    }
}
