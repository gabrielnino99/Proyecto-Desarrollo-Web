package com.example.proyectodw;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.proyectodw.DAO.AgujeroDeGusanoRepository;
import com.example.proyectodw.DAO.EstrellaRepository;
import com.example.proyectodw.DAO.NaveRepository;
import com.example.proyectodw.DAO.PlanetaRepository;
import com.example.proyectodw.DAO.UsuarioRepository;
import com.example.proyectodw.model.AgujeroDeGusano;
import com.example.proyectodw.model.Estrella;
import com.example.proyectodw.model.Nave;
import com.example.proyectodw.model.Planeta;
import com.example.proyectodw.model.Usuario;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@ActiveProfiles("systemtest")
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
public class VisitarEstrellaSystemTest {

    @Autowired
    private AgujeroDeGusanoRepository agujeroDeGusanoRepository;

    @Autowired
    private EstrellaRepository estrellaRepository;

    @Autowired
    private PlanetaRepository planetaRepository;

    @Autowired
    private NaveRepository naveRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    String baseUrl;

    private ChromeDriver browser;
    private WebDriverWait wait;

    //Sirve para establecer variables o parametros qu necesitemos antes de ejecutar las pruebas
    @BeforeEach
    void init(){
        
        AgujeroDeGusano agujero = new AgujeroDeGusano(1);
        agujeroDeGusanoRepository.save(agujero);
        Estrella estrella1 = new Estrella("Spica", 1, 1, 1, 1);
        estrellaRepository.save(estrella1);
        Estrella estrella2 = new Estrella("Polaris", 2, 2, 2, 2);
        estrellaRepository.save(estrella2);
        //Nave y Usuario
        Nave nave = new Nave("Voyager", 0.0, 120.0, 300, estrella1, 1);
        naveRepository.save(nave);
        Usuario usuario1 = new Usuario(11,"Makubex", "1", "Capitan", "jazz@gmail.com", 1000000, 0, nave);
        usuarioRepository.save(usuario1);

        Planeta planeta = new Planeta("Tatooine", 1, estrella1);
        planetaRepository.save(planeta);
        Planeta planeta2 = new Planeta("Alderan", 2, estrella1);
        planetaRepository.save(planeta2);

        System.setProperty("webdriver.chrome.driver", 
        "src\\test\\java\\com\\example\\proyectodw\\resources\\chromedriver.exe");
        
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-gpu");
        options.merge(DesiredCapabilities.chrome());
        this.browser = new ChromeDriver(options);
        this.wait = new WebDriverWait(this.browser, 10);
        
        this.baseUrl = "http://localhost:4200";
        
    }

    @AfterEach
    void end(){
        this.browser.quit();
    }
    /**
     * CP 5.1
     * Corresponde al CU-005 Visitar Estrella
     * Se entra a la vista interior de la estrella donde pueden haber estrellas
     */
    @Test
    void cp5_1(){
        String nombreEstrella = "";
        String nombrePlaneta0 = "";
        String nombrePlaneta1 = "";

       try{
            this.browser.get(this.baseUrl + "/dashboard/usuario/5/navegacion/4");
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnVsitar")));
            WebElement btnVsitar = this.browser.findElementById("btnVsitar");
            btnVsitar.click();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("h1Estrella")));
            WebElement h1Estrella = this.browser.findElementById("h1Estrella");
            nombreEstrella = h1Estrella.getText();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("h5Planeta0")));
            WebElement h5Planeta0 = this.browser.findElementById("h5Planeta0");
            nombrePlaneta0 = h5Planeta0.getText();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("h5Planeta1")));
            WebElement h5Planeta1 = this.browser.findElementById("h5Planeta1");
            nombrePlaneta1 = h5Planeta1.getText();            
        }
       catch(TimeoutException te){
            
       }
       finally{
           assertEquals("Spica", nombreEstrella);
           assertEquals("Tatooine", nombrePlaneta0);
           assertEquals("Alderan", nombrePlaneta1);
       }
    }


}