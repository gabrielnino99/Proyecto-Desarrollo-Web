package com.example.proyectodw.controller;

import java.util.List;

//import com.example.proyectodw.DAO.NaveRepository;
import com.example.proyectodw.services.NaveService;
import com.example.proyectodw.model.Nave;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NaveController {
    
    @Autowired
    private NaveService naveService;

    @PostMapping("/addNave")
    public Nave addNave(@RequestBody Nave nave){
        return naveService.crearNave(nave);
    }

    @PostMapping("/addNaves")
    public List<Nave> addNaves(@RequestBody List<Nave> naves){
        return naveService.crearNaves(naves);
    }

    @GetMapping("/nave/{id}")
    public Nave getNaveById(@PathVariable Long id){
        return naveService.getNaveById(id);
    }

    @GetMapping("/naves")
    public List<Nave> getAllNaves(){
        return naveService.getNaves();
    }

    @PutMapping("/updateNave")
    public Nave updateNave(@RequestBody Nave nave){
        return naveService.updateNave(nave);
    }

    @DeleteMapping("/nave/{id}")
    public String deleteNave(@PathVariable Long id){
        return naveService.deleteNaveById(id);
    }


}
