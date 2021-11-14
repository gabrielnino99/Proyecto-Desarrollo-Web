package com.example.proyectodw;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.when;
import static org.mockito.AdditionalMatchers.geq;
import static org.mockito.AdditionalMatchers.leq;

import java.io.UnsupportedEncodingException;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.example.proyectodw.DAO.AgujeroDeGusanoEstrellaRepository;
import com.example.proyectodw.DAO.AgujeroDeGusanoRepository;
import com.example.proyectodw.DAO.EstrellaRepository;
import com.example.proyectodw.model.AgujeroDeGusanoEstrella;
import com.example.proyectodw.model.AgujeroDeGusano;
import com.example.proyectodw.model.Estrella;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("unittest")
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureMockMvc
public class AgujeroDeGusanoEstrellaControllerUnitTest {
    @Autowired
    ObjectMapper mapper;

    @Autowired
    MockMvc mvc;

    //@Autowired
    @MockBean
    private AgujeroDeGusanoRepository agujeroDeGusanoRepository;

    //@Autowired
    @MockBean
    private AgujeroDeGusanoEstrellaRepository agujeroDeGusanoEstrellaRepository;

    //@Autowired
    @MockBean
    private EstrellaRepository estrellaRepository;

     //Sirve para establecer variables o parametros qu necesitemos antes de ejecutar las pruebas
     @BeforeEach
     void init(){
         /*
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
         */
        when(agujeroDeGusanoEstrellaRepository.findById(leq(3l))).thenThrow(new NoSuchElementException());
        when(agujeroDeGusanoEstrellaRepository.findById(4l)).thenReturn(Optional.of(new AgujeroDeGusanoEstrella(4l,"A", new AgujeroDeGusano(1l, 1), new Estrella(2l,"Spica", 1, 1, 1, 1))));
        when(agujeroDeGusanoEstrellaRepository.findById(5l)).thenReturn(Optional.of(new AgujeroDeGusanoEstrella(5l,"B", new AgujeroDeGusano(1l, 1), new Estrella("Polaris", 2, 2, 2, 2))));
        when(agujeroDeGusanoEstrellaRepository.findById(geq(6l))).thenThrow(new NoSuchElementException());
     }
     
     @Test
    void getAgujeroDeGusanoEstrellaPoloA(){
        try{
            Long id = Integer.toUnsignedLong(4);
            MockHttpServletRequestBuilder request = get("/agujeroDeGusanoEstrella/{id}", id);
            //MvcResult result = mvc.perform(request).andReturn().getResponse().
            String strResult = mvc.perform(request)
            .andExpect(status().isOk())
            .andReturn().getResponse().getContentAsString();
            //AgujeroDeGusanoEstrella result = mapper.readValue(strResult, AgujeroDeGusanoEstrella.class);
            //assertEquals("A", result.getPolo());
        }
        catch(UnsupportedEncodingException ue){

        }
        catch(Exception e){

        }
    }
    /*
    @Test
    void getAgujeroDeGusanoEstrellaPoloEstrella1(){
        Long id = Integer.toUnsignedLong(4);
        
    }

    @Test
    void getAgujeroDeGusanoEstrellaPoloB(){
        Long id = Integer.toUnsignedLong(5);
        
    }

    @Test
    void getAgujeroDeGusanoEstrellaPoloEstrella2(){
        Long id = Integer.toUnsignedLong(5);
       
    }
    */
}
