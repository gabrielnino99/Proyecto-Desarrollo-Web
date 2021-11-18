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
import com.example.proyectodw.DAO.PlanetaRepository;
import com.example.proyectodw.DAO.PlanetaProductoRepository;
import com.example.proyectodw.DAO.ProductoRepository;
import com.example.proyectodw.model.Estrella;
import com.example.proyectodw.model.Planeta;
import com.example.proyectodw.model.PlanetaProducto;
import com.example.proyectodw.model.Producto;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("integrationtest")
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
public class PlanetaProductoControllerIntegrationTest {

    @Autowired
    private EstrellaRepository estrellaRepository;

    @Autowired
    private PlanetaRepository planetaRepository;

    @Autowired
    private PlanetaProductoRepository planetaProductoRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @LocalServerPort
    private int port;

    @Autowired
    TestRestTemplate rest;

    //Sirve para establecer variables o parametros qu necesitemos antes de ejecutar las pruebas
    @BeforeEach
    void init(){
        
        Estrella estrella1 = new Estrella("Rigel", 1, 1, 1, 1);
        estrellaRepository.save(estrella1);
        Planeta planeta = new Planeta("Naboo", 1, estrella1);
        planetaRepository.save(planeta);
        Producto producto = new Producto("Berserker", 1, 0, 24.0);
        productoRepository.save(producto);
        Producto producto2 = new Producto("Amuleto", 2, 0, 24.0);
        productoRepository.save(producto2);
        PlanetaProducto pp1 = new PlanetaProducto(100, 10, 50, planeta, producto);
        planetaProductoRepository.save(pp1);
        PlanetaProducto pp2 = new PlanetaProducto(100, 30, 50, planeta, producto2);
        planetaProductoRepository.save(pp2);
    }

    @Test
    void getPlanetaProductoById(){
        Long id = 6l;
        PlanetaProducto pp = rest.getForObject("http://localhost:" + port + "/planetaProducto/" + id, PlanetaProducto.class);
        assertEquals(30, pp.getStock());
    }

    @Test
    void updatePlanetaProducto(){
        Long id = 5l;
        rest.put("http://localhost:" + port +"/updatePlanetaProducto",  new PlanetaProducto(id, 100, 5, 50, new Planeta(2l, 1,"Naboo", new Estrella(1l,"Rigel", 1, 1, 1, 1)), new Producto(3l, 1,"Berserker", 0, 24.0)), PlanetaProducto.class);
        PlanetaProducto pp = rest.getForObject("http://localhost:" + port + "/planetaProducto/" + id, PlanetaProducto.class);
        assertEquals(5, pp.getStock());
    }
   
}
