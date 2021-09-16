package com.example.proyectodw.controller;

import com.example.proyectodw.model.TransaccionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/transaccion")
public class TransaccionController {
    
    @Autowired
    TransaccionRepository transaccionRepository;
}
