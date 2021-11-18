package com.example.proyectodw;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.proyectodw.DAO.EstrellaRepository;
import com.example.proyectodw.DAO.NaveRepository;
import com.example.proyectodw.model.Estrella;
import com.example.proyectodw.model.Nave;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("integrationtest")
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
public class NaveControllerIntegrationTest {

    @Autowired
    private EstrellaRepository estrellaRepository;

    @Autowired
    private NaveRepository naveRepository;

    @LocalServerPort
    private int port;

    @Autowired
    TestRestTemplate rest;

    //Sirve para establecer variables o parametros qu necesitemos antes de ejecutar las pruebas
    @BeforeEach
    void init(){
        
        Estrella estrella1 = new Estrella("Betelgeuse", 1, 1, 1, 1);
        estrellaRepository.save(estrella1);
        Nave nave = new Nave("Voyager", 0.0, 120.0, 300, estrella1, 1);
        naveRepository.save(nave);
    }

    @Test
    void getNaveById(){
        Long id = 2l;
        Nave nave = rest.getForObject("http://localhost:" + port +"/nave/" + id, Nave.class);
        assertEquals("Voyager", nave.getNombre());
    }

    @Test
    void getEstrellaNaveById(){
        Long id = 2l;
        Estrella estrella = rest.getForObject("http://localhost:" + port +"/nave/" + id + "/estrella", Estrella.class);
        assertEquals("Betelgeuse", estrella.getNombre());
    }

    @Test
    void updateNave(){
        Long id = 2l;
        rest.put("http://localhost:" + port +"/updateNave", new Nave(id, "Falcon", 0.0, 120.0, 300, 1, new Estrella(1l,"Betelgeuse", 1, 1, 1, 1)), Nave.class);
        Nave nave = rest.getForObject("http://localhost:" + port +"/nave/" + id, Nave.class);
        assertEquals("Falcon", nave.getNombre());
    }

}
