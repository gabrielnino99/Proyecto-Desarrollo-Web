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

import com.example.proyectodw.DAO.AgujeroDeGusanoEstrellaRepository;
import com.example.proyectodw.DAO.AgujeroDeGusanoRepository;
import com.example.proyectodw.DAO.EstrellaRepository;
import com.example.proyectodw.model.AgujeroDeGusanoEstrella;
import com.example.proyectodw.model.AgujeroDeGusano;
import com.example.proyectodw.model.Estrella;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("integrationtest")
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
public class AgujeroDeGusanoEstrellaControllerIntegrationTest {
    
    @Autowired
    private AgujeroDeGusanoRepository agujeroDeGusanoRepository;

    @Autowired
    private AgujeroDeGusanoEstrellaRepository agujeroDeGusanoEstrellaRepository;

    @Autowired
    private EstrellaRepository estrellaRepository;

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
    }

    @Test
    void getAgujeroDeGusanoEstrellaPoloA(){
        Long id = 4l;
        AgujeroDeGusanoEstrella agujeroEstrellaRest = rest.getForObject("http://localhost:" + port +"/agujeroDeGusanoEstrella/" + id, AgujeroDeGusanoEstrella.class);
        assertEquals("A", agujeroEstrellaRest.getPolo());
    }

    @Test
    void getAgujeroDeGusanoEstrellaPoloEstrella1(){
        Long id = 4l;
        AgujeroDeGusanoEstrella agujeroEstrellaRest = rest.getForObject("http://localhost:" + port +"/agujeroDeGusanoEstrella/" + id, AgujeroDeGusanoEstrella.class);
        assertEquals("Spica", agujeroEstrellaRest.getEstrella().getNombre());
    }

    @Test
    void getAgujeroDeGusanoEstrellaPoloB(){
        Long id = 5l;
        AgujeroDeGusanoEstrella agujeroEstrellaRest = rest.getForObject("http://localhost:" + port +"/agujeroDeGusanoEstrella/" + id, AgujeroDeGusanoEstrella.class);
        assertEquals("B", agujeroEstrellaRest.getPolo());
    }

    @Test
    void getAgujeroDeGusanoEstrellaPoloEstrella2(){
        Long id = 5l;
        AgujeroDeGusanoEstrella agujeroEstrellaRest = rest.getForObject("http://localhost:" + port +"/agujeroDeGusanoEstrella/" + id, AgujeroDeGusanoEstrella.class);
        assertEquals("Polaris", agujeroEstrellaRest.getEstrella().getNombre());
    }

}
