package com.example.proyectodw.controller;

import com.example.proyectodw.model.ProductoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/producto")
public class ProductoController {
    
    @Autowired
    ProductoRepository productoRepository;
}