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
import com.example.proyectodw.DAO.NaveProductoRepository;
import com.example.proyectodw.DAO.NaveRepository;
import com.example.proyectodw.DAO.PlanetaProductoRepository;
import com.example.proyectodw.DAO.PlanetaRepository;
import com.example.proyectodw.DAO.ProductoRepository;
import com.example.proyectodw.DAO.UsuarioRepository;
import com.example.proyectodw.model.AgujeroDeGusano;
import com.example.proyectodw.model.Estrella;
import com.example.proyectodw.model.Nave;
import com.example.proyectodw.model.NaveProducto;
import com.example.proyectodw.model.Planeta;
import com.example.proyectodw.model.PlanetaProducto;
import com.example.proyectodw.model.Producto;
import com.example.proyectodw.model.Usuario;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@ActiveProfiles("systemtest")
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
public class VenderSystemTest {

    @Autowired
    private AgujeroDeGusanoRepository agujeroDeGusanoRepository;

    @Autowired
    private EstrellaRepository estrellaRepository;

    @Autowired
    private PlanetaRepository planetaRepository;

    @Autowired
    private NaveRepository naveRepository;

    @Autowired
    private NaveProductoRepository naveProductoRepository;

    @Autowired
    private PlanetaProductoRepository planetaProductoRepository;

    @Autowired
    private ProductoRepository productoRepository;

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

        Producto producto = new Producto("Berserker", 1, 0, 24.0);
        productoRepository.save(producto);
        Producto producto2 = new Producto("Amuleto", 2, 0, 24.0);
        productoRepository.save(producto2);
        Producto producto3 = new Producto("Materia", 3, 0, 24.0);
        productoRepository.save(producto3);
        PlanetaProducto pp1 = new PlanetaProducto(100, 10, 50, planeta, producto);
        planetaProductoRepository.save(pp1);
        PlanetaProducto pp2 = new PlanetaProducto(100, 30, 50, planeta, producto2);
        planetaProductoRepository.save(pp2);
        PlanetaProducto pp3 = new PlanetaProducto(100, 30, 50, planeta, producto3);
        planetaProductoRepository.save(pp3);

        NaveProducto np = new NaveProducto(10, nave, producto);
        naveProductoRepository.save(np);

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
     * CP 6.1
     * Corresponde al CU-006 Visitar Planeta combinado con el CU-009 Ver Producto
     * Dentro de una estrella con planetas se selecciona uno de los planetas y al final
     * se muestra la lista de los productos que se venden en ese planeta.
     * 
     * 
     */
    @Test
    void cp6_1(){
        String esperado = "Nombre de Producto: Materia\nStock: 35\nFactor Demanda: 100\nFactor Oferta: 50";
        String resultado = "";
        try{
            this.browser.get(this.baseUrl + "/dashboard/usuario/5/navegacion/4/estrella/2/planeta/6/planeta-producto/10/vender/13");
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("inputCantidad")));
            WebElement inputCantidad = this.browser.findElement(By.id("inputCantidad"));
            inputCantidad.sendKeys("5");
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnVender")));
            WebElement btnVender = this.browser.findElementById("btnVender");
            btnVender.click();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("h5DatosProducto")));
            WebElement h5DatosProducto = this.browser.findElement(By.id("h5DatosProducto"));
            resultado = h5DatosProducto.getText();
        }
       catch(TimeoutException te){
            System.out.println("El tiempo se agoto");
       }
       finally{
            assertEquals(esperado, resultado);  
        }
    }


}
