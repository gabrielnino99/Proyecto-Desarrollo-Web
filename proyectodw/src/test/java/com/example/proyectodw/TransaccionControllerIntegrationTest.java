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
import com.example.proyectodw.DAO.UsuarioRepository;
import com.example.proyectodw.model.Estrella;
import com.example.proyectodw.model.Nave;
import com.example.proyectodw.model.Transaccion;
import com.example.proyectodw.model.Usuario;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("integrationtest")
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
public class TransaccionControllerIntegrationTest {

    @Autowired
    private EstrellaRepository estrellaRepository;

    @Autowired
    private NaveRepository naveRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

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
        Usuario usuario = new Usuario(11,"Makubex", "1", "capitan", "jazz@gmail.com", 1000000, 0, nave);
        usuarioRepository.save(usuario);
    }

    @Test
    void addTransaccion(){
        Transaccion transaccion = rest.postForObject(
            "http://localhost:" + port +"/addTransaccion", new Transaccion(
                1,"compra", 50000, new Usuario(
                    3l,11,"Makubex", "1", "capitan", "jazz@gmail.com", 1000000, 0, new Nave(
                        2l, "Voyager", 0.0, 120.0, 300, 1, new Estrella(
                            1l,"Betelgeuse", 1, 1, 1, 1)))), Transaccion.class);
        assertEquals("compra", transaccion.getTipo());
    }
   
}