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
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.proyectodw.DAO.AgujeroDeGusanoRepository;
import com.example.proyectodw.DAO.EstrellaRepository;
import com.example.proyectodw.DAO.NaveRepository;
import com.example.proyectodw.DAO.UsuarioRepository;
import com.example.proyectodw.model.AgujeroDeGusano;
import com.example.proyectodw.model.Estrella;
import com.example.proyectodw.model.Nave;
import com.example.proyectodw.model.Usuario;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@ActiveProfiles("systemtest")
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
public class LoginSystemTest {

    @Autowired
    private AgujeroDeGusanoRepository agujeroDeGusanoRepository;

    @Autowired
    private EstrellaRepository estrellaRepository;

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
     * CP 1.1
     * Corresponde al CU-001 Iniciar Sesión
     */
    @Test
    void cp1_1(){
        String urlActual = "";
       try{
            this.browser.get(this.baseUrl + "/login");
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("inputUsuario")));
            WebElement inputUsuario = this.browser.findElementById("inputUsuario");
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("inputPassword")));
            WebElement inputPassword = this.browser.findElementById("inputPassword");
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnIngresar")));
            WebElement btnIngresar = this.browser.findElementById("btnIngresar");
            inputUsuario.sendKeys("entrega2");
            inputPassword.sendKeys("password");
            btnIngresar.click();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("h1Bienvenida")));
            urlActual = this.browser.getCurrentUrl();
        }
       catch(TimeoutException te){
            System.out.println("El tiempo se agoto");
       }
       finally{
        assertEquals(this.baseUrl + "/dashboard", urlActual);
       }
    }


}
