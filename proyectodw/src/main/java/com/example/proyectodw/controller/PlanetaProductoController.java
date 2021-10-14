package com.example.proyectodw.controller;


import com.example.proyectodw.model.PlanetaProducto;
import com.example.proyectodw.DAO.PlanetaProductoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlanetaProductoController {
    @Autowired
    PlanetaProductoRepository planetaProductoRepository;    

}
