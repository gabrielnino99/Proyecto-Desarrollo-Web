package com.example.proyectodw.controller;

import com.example.proyectodw.model.PlanetaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/planeta")
public class PlanetaController {
    
    @Autowired
    PlanetaRepository planetaRepository;
}
