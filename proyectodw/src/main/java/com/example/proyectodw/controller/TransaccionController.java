package com.example.proyectodw.controller;

import com.example.proyectodw.DAO.TransaccionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransaccionController {
    
    @Autowired
    TransaccionRepository transaccionRepository;
}
