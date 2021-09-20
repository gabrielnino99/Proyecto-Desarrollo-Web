package com.example.proyectodw.controller;

import com.example.proyectodw.DAO.AgujeroDeGusanoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/agujeroDeGusano")
public class AgujeroDeGusanoController {
    
    @Autowired
    AgujeroDeGusanoRepository agujeroDeGusanoRepository;
}