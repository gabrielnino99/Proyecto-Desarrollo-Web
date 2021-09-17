package com.example.proyectodw.controller;

import com.example.proyectodw.DAO.NaveRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/nave")
public class NaveController {
    
    @Autowired
    NaveRepository naveRepository;
}
