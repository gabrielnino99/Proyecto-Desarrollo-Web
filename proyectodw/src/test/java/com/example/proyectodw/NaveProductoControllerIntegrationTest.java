package com.example.proyectodw;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.proyectodw.DAO.EstrellaRepository;
import com.example.proyectodw.DAO.NaveRepository;
import com.example.proyectodw.DAO.NaveProductoRepository;
import com.example.proyectodw.DAO.ProductoRepository;
import com.example.proyectodw.model.Estrella;
import com.example.proyectodw.model.Nave;
import com.example.proyectodw.model.NaveProducto;
import com.example.proyectodw.model.Producto;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("integrationtest")
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
public class NaveProductoControllerIntegrationTest {

    @Autowired
    private EstrellaRepository estrellaRepository;

    @Autowired
    private NaveRepository naveRepository;

    @Autowired
    private NaveProductoRepository naveProductoRepository;

    @Autowired
    private ProductoRepository productoRepository;

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
        Producto producto = new Producto("Rubi", 1, 0, 24.0);
        productoRepository.save(producto);
        NaveProducto np = new NaveProducto(1, nave, producto);
        naveProductoRepository.save(np);
        Producto producto2 = new Producto("Elixir", 2, 0, 24.0);
        productoRepository.save(producto2);
    }

    @Test
    void addNaveProducto(){
        NaveProducto np = rest.postForObject("http://localhost:" + port +"/addNaveProducto", new NaveProducto(5,new Nave(2l,"Voyager", 0.0, 120.0, 300, 1,new Estrella(1l,"Betelgeuse", 1, 1, 1, 1)), new Producto(5l,2,"Elixir", 0, 24.0)), NaveProducto.class);
        assertEquals(5, np.getCantidad());
    }

    @Test
    void getNaveProductoById(){
        Long nid = 2l;
        Long prid = 3l;
        NaveProducto np = rest.getForObject("http://localhost:" + port +"/naveProducto/" + nid + "/" + prid, NaveProducto.class);
        assertEquals(1, np.getCantidad());
    }

    @Test
    void updateNaveProducto(){
        Long id = 4l;
        rest.put("http://localhost:" + port +"/updateNaveProducto", new NaveProducto(id, 2,new Nave(2l,"Voyager", 0.0, 120.0, 300, 1,new Estrella(1l,"Betelgeuse", 1, 1, 1, 1)), new Producto(3l,1,"Rubi", 0, 24.0)), Nave.class);
        Long nid = 2l;
        Long prid = 3l;
        NaveProducto np = rest.getForObject("http://localhost:" + port +"/naveProducto/" + nid + "/" + prid, NaveProducto.class);
        assertEquals(2, np.getCantidad());
    }
   
}