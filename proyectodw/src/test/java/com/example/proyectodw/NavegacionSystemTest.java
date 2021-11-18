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
import com.example.proyectodw.DAO.AgujeroDeGusanoEstrellaRepository;
import com.example.proyectodw.DAO.EstrellaRepository;
import com.example.proyectodw.DAO.NaveRepository;
import com.example.proyectodw.DAO.PlanetaRepository;
import com.example.proyectodw.DAO.UsuarioRepository;
import com.example.proyectodw.model.AgujeroDeGusano;
import com.example.proyectodw.model.AgujeroDeGusanoEstrella;
import com.example.proyectodw.model.Estrella;
import com.example.proyectodw.model.Nave;
import com.example.proyectodw.model.Planeta;
import com.example.proyectodw.model.Usuario;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@ActiveProfiles("systemtest")
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
public class NavegacionSystemTest {

    @Autowired
    private AgujeroDeGusanoRepository agujeroDeGusanoRepository;

    @Autowired
    private AgujeroDeGusanoEstrellaRepository agujeroDeGusanoEstrellaRepository;

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
        Estrella estrella12 = new Estrella("Chara", 12, 12, 12, 12);
        estrellaRepository.save(estrella12);
        Estrella estrella13 = new Estrella("Electra", 13, 13, 13, 13);
        estrellaRepository.save(estrella13);
        Estrella estrella14 = new Estrella("Fafnir", 14, 14, 14, 14);
        estrellaRepository.save(estrella14);
        Estrella estrella15 = new Estrella("Ginan", 15, 15, 15, 15);
        estrellaRepository.save(estrella15);
        Estrella estrella16 = new Estrella("Jabbah", 16, 16, 16, 16);
        estrellaRepository.save(estrella16);

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
     * CP 4.1
     * Corresponde al CU-004 Manejar Nave
     * La prueba debe navegar a través de 2 estrellas siempre validando los datos de la estrella
     * donde está ubicada la nave.
     */
    @Test
    void cp4_1(){
        String estrella1 = "";
        String estrella2 = "";
        //String estrella3 = "";
       try{
            this.browser.get(this.baseUrl + "/dashboard/usuario/5/navegacion/4");
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("h1SelectedEstrella")));
            WebElement h1SelectedEstrella = this.browser.findElementById("h1SelectedEstrella");
            estrella1 =  h1SelectedEstrella.getText();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("imgEstrella5")));
            WebElement imgEstrella5 = this.browser.findElementById("imgEstrella5");
            imgEstrella5.click();
            wait.until(ExpectedConditions.textToBePresentInElement(h1SelectedEstrella,"ID: 13, Nombre: Betelgeuse\n(6, 6, 6)"));
            estrella2 =  h1SelectedEstrella.getText();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("imgEstrella9")));
            WebElement imgEstrella9 = this.browser.findElementById("imgEstrella9");
            imgEstrella9.click();
            wait.until(ExpectedConditions.textToBePresentInElement(h1SelectedEstrella,"ID: 18, Nombre: Regulus\n(11, 11, 11)"));
            //estrella3 =  h1SelectedEstrella.getText();
        }
       catch(TimeoutException te){
            System.out.println("El tiempo se agoto");
       }
       finally{
        assertEquals("ID: 2, Nombre: Spica\n(1, 1, 1)", estrella1);
        assertEquals("ID: 13, Nombre: Betelgeuse\n(6, 6, 6)", estrella2);
        //assertEquals("ID: 18, Nombre: Regulus\n(11, 11, 11)", estrella3);    
       }
    }


}
