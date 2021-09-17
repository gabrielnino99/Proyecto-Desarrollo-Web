package com.example.proyectodw.controller;

import com.example.proyectodw.DAO.EstrellaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/estrella")
public class EstrellaController {
    
    @Autowired
    EstrellaRepository estrellaRepository;
}

