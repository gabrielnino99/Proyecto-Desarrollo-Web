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

import com.example.proyectodw.DAO.AgujeroDeGusanoRepository;
import com.example.proyectodw.DAO.AgujeroDeGusanoEstrellaRepository;
import com.example.proyectodw.DAO.EstrellaRepository;
import com.example.proyectodw.DAO.PlanetaRepository;
import com.example.proyectodw.model.AgujeroDeGusano;
import com.example.proyectodw.model.AgujeroDeGusanoEstrella;
import com.example.proyectodw.model.Estrella;
import com.example.proyectodw.model.Planeta;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("integrationtest")
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
public class EstrellaControllerIntegrationTest {

    @Autowired
    private AgujeroDeGusanoRepository agujeroDeGusanoRepository;

    @Autowired
    private AgujeroDeGusanoEstrellaRepository agujeroDeGusanoEstrellaRepository;

    @Autowired
    private EstrellaRepository estrellaRepository;

    @Autowired
    private PlanetaRepository planetaRepository;

    @LocalServerPort
    private int port;

    @Autowired
    TestRestTemplate rest;

    //Sirve para establecer variables o parametros qu necesitemos antes de ejecutar las pruebas
    @BeforeEach
    void init(){
        AgujeroDeGusano agujero = new AgujeroDeGusano(1);
        agujeroDeGusanoRepository.save(agujero);
        Estrella estrella1 = new Estrella("Spica", 1, 1, 1, 1);
        estrellaRepository.save(estrella1);
        Estrella estrella2 = new Estrella("Polaris", 2, 2, 2, 2);
        estrellaRepository.save(estrella2);
        AgujeroDeGusanoEstrella agujeroEstrellaA = new AgujeroDeGusanoEstrella("A", agujero,estrella1);
        agujeroDeGusanoEstrellaRepository.save(agujeroEstrellaA);
        AgujeroDeGusanoEstrella agujeroEstrellaB = new AgujeroDeGusanoEstrella("B", agujero,estrella2);
        agujeroDeGusanoEstrellaRepository.save(agujeroEstrellaB);
        Planeta planeta = new Planeta("Tatooine", 1, estrella1);
        planetaRepository.save(planeta);
        Planeta planeta2 = new Planeta("Alderan", 2, estrella1);
        planetaRepository.save(planeta2);
        Estrella estrella3 = new Estrella("Aldebaran", 3, 3, 3, 3);
        estrellaRepository.save(estrella3);
        Estrella estrella4 = new Estrella("Altair", 4, 4, 4, 4);
        estrellaRepository.save(estrella4);
        Estrella estrella5 = new Estrella("Antares", 5, 5, 5, 5);
        estrellaRepository.save(estrella5);
        Estrella estrella6 = new Estrella("Betelgeuse", 6, 6, 6, 6);
        estrellaRepository.save(estrella6);
        Estrella estrella7 = new Estrella("Bellatrix", 7, 7, 7, 7);
        estrellaRepository.save(estrella7);
        Estrella estrella8 = new Estrella("Sirius", 8, 8, 8, 8);
        estrellaRepository.save(estrella8);
        Estrella estrella9 = new Estrella("Mira", 9, 9, 9, 9);
        estrellaRepository.save(estrella9);
        Estrella estrella10 = new Estrella("Canopus", 10, 10, 10, 10);
        estrellaRepository.save(estrella10);
        Estrella estrella11 = new Estrella("Regulus", 11, 11, 11, 11);
        estrellaRepository.save(estrella11);
    }

    @Test
    void getEstrellaById(){
        Long id = 3l;
        Estrella estrella = rest.getForObject("http://localhost:" + port +"/estrella/" + id, Estrella.class);
        assertEquals("Polaris", estrella.getNombre());
    }

    @Test
    void getPlanetasEstrellaById(){
        Long id = 2l;
        Planeta[] planetas = rest.getForObject("http://localhost:" + port +"/estrella/" + id + "/planetas", Planeta[].class);
        assertEquals("Tatooine", planetas[0].getNombre());
    }

    
    @Test
    void getAgujeroDeGusanoEstrellaById(){
        Long id = 2l;
        AgujeroDeGusanoEstrella agujero = rest.getForObject("http://localhost:" + port +"/estrella/" + id + "/agujerosDeGusano", AgujeroDeGusanoEstrella.class);
        assertEquals("B", agujero.getPolo());
    }

    @Test
    void getEstrellasCercanasById(){
        Long id = 2l;
        Estrella[] estrellas = rest.getForObject("http://localhost:" + port + "/estrellasCercanas/" + id, Estrella[].class);
        assertEquals(10, estrellas.length);
    }


}
