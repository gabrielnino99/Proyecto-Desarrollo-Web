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
import com.example.proyectodw.model.Usuario;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("integrationtest")
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
public class UsuarioControllerIntegrationTest {

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
        Usuario usuario1 = new Usuario(11,"Makubex", "1", "Capitan", "jazz@gmail.com", 1000000, 0, nave);
        usuarioRepository.save(usuario1);
        Usuario usuario2 = new Usuario(12,"Luka", "2", "Piloto", "maya@gmail.com", 1000000, 0, nave);
        usuarioRepository.save(usuario2);
        Usuario usuario3 = new Usuario(13,"Ragnar", "3", "Comerciante", "travis@gmail.com", 1000000, 0, nave);
        usuarioRepository.save(usuario3);
    }

    @Test
    void addUsuario(){
        Usuario usuario = rest.postForObject(
            "http://localhost:" + port +"/addUsuario", new Usuario(
                    14,"Sonya", "4", "Capitan", "diva@gmail.com", 1000000, 0, new Nave(
                        2l, "Voyager", 0.0, 120.0, 300, 1, new Estrella(
                            1l,"Betelgeuse", 1, 1, 1, 1))), Usuario.class);
        assertEquals("Sonya", usuario.getUserName());
    }

    @Test
    void addUsuarios(){
        Estrella estrella1 = new Estrella(1l, "Betelgeuse", 1, 1, 1, 1);
        Nave nave = new Nave(2l, "Voyager", 0.0, 120.0, 300, 1, estrella1);
        Usuario usuario2 = new Usuario(14,"Sonya", "4", "Capitan", "diva@gmail.com", 1000000, 0, nave);
        Usuario usuario3 = new Usuario(15,"Thor", "5", "Comerciante", "yoko@gmail.com", 1000000, 0, nave);
        Usuario[] usuarios = {usuario2, usuario3};
        Usuario[] usuarios2 = rest.postForObject(
            "http://localhost:" + port +"/addUsuarios", usuarios, Usuario[].class);
        assertEquals("Thor", usuarios2[1].getUserName());
    }

    @Test
    void getUsuarioById(){
        Long id = 4l;
        Usuario usuario = rest.getForObject("http://localhost:" + port +"/usuario/" + id, Usuario.class);
        assertEquals("Luka", usuario.getUserName());
    }

    @Test
    void getNaveUsuarioById(){
        Long id = 5l;
        Nave nave = rest.getForObject("http://localhost:" + port +"/usuario/" + id + "/nave", Nave.class);
        assertEquals("Voyager", nave.getNombre());
    }

    @Test
    void getAllUsuarios(){
        Usuario[] usuarios = rest.getForObject("http://localhost:" + port +"/usuarios", Usuario[].class);
        assertEquals(3, usuarios.length);
    }

    void updateUsuario(){
        Long id = 5l;
        rest.put("http://localhost:" + port +"/updateUsuario", new Usuario(
            id,15,"Beorn", "5", "Capitan", "jazz@gmail.com", 1000000, 0, new Nave(
                2l, "Voyager", 0.0, 120.0, 300, 1, new Estrella(
                    1l,"Betelgeuse", 1, 1, 1, 1))), Usuario.class);
        Usuario usuario = rest.getForObject("http://localhost:" + port +"/usuario/" + id, Usuario.class);
        assertEquals("Beorn", usuario.getUserName());
    }

    @Test
    void deleteUsuario(){
        Long id = 5l;
        rest.delete("http://localhost:" + port +"/usuario/" + id);
        Usuario[] usuarios = rest.getForObject("http://localhost:" + port +"/usuarios", Usuario[].class);
        assertEquals(2, usuarios.length);
    }
   
}
