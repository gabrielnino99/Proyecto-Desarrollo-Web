package com.example.proyectodw.controller;

import com.example.proyectodw.DAO.AgujeroDeGusanoEstrellaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AgujeroDeGusanoEstrellaController {
    
    @Autowired
    AgujeroDeGusanoEstrellaRepository agujeroDeGusanoEstrellaRepository;
}
