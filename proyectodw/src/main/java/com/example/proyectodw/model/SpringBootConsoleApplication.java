package com.example.proyectodw.model;

import java.util.Random;
import javax.transaction.Transactional;

import org.apache.commons.text.RandomStringGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SpringBootConsoleApplication implements CommandLineRunner{
    private static final Logger LOG = LoggerFactory.getLogger(SpringBootConsoleApplication.class);
    public static final int NUM_ESTRELLAS = 40000;
    public static final int NUM_PRODUCTOS = 500;
    public static final int NUM_NAVES = 20;
    public static final int NUM_USUARIOS = 100;
    public static final int NUM_EQUIPOS = 10;
    
    @Autowired
    EstrellaRepository estrellaRepository;

    @Autowired
    PlanetaRepository planetaRepository;

    @Autowired
    ProductoRepository productoRepository;

    @Autowired
    NaveRepository naveRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    /*public static void main(String[] args) {
        LOG.info("STARTING THE APPLICATION");
        SpringApplication app = new SpringApplication(SpringBootConsoleApplication.class);
        //Se especifica la propiedad spring.main.web-application-type=NONE aplicada a esta clase
        app.setWebApplicationType(WebApplicationType.NONE);
        app.run(args);
        
        LOG.info("APPLICATION FINISHED");
    }*/
 
    @Override
    @Transactional
    public void run(String... args) {
        Random randomEstrella = new Random(1234);
        Random randomPlaneta = new Random(5678);
        Random randomProducto = new Random(123);
        Random randomNave = new Random(456);
        Random randomUsuario = new Random(789);
        RandomStringGenerator randomGenEstrella = new RandomStringGenerator.Builder().withinRange('a','z').usingRandom(randomEstrella::nextInt).build();
        RandomStringGenerator randomGenPlaneta = new RandomStringGenerator.Builder().withinRange('a','z').usingRandom(randomPlaneta::nextInt).build();
        RandomStringGenerator randomGenProducto = new RandomStringGenerator.Builder().withinRange('a','z').usingRandom(randomProducto::nextInt).build();
        RandomStringGenerator randomGenNave = new RandomStringGenerator.Builder().withinRange('a','z').usingRandom(randomNave::nextInt).build();
        RandomStringGenerator randomGenUsuario = new RandomStringGenerator.Builder().withinRange('a','z').usingRandom(randomUsuario::nextInt).build();
        
        LOG.info("EXECUTING : command line runner");
        //Inserta las estrellas
        LOG.info("INSERTANDO: Estrellas con 1% de probabilidad de tener entre 1 y 3 Planetas");
        int contPlaneta = 0;
        for(int i=0;i<NUM_ESTRELLAS;i++){
            String nombreEstrella = randomGenEstrella.generate(5,15);
            int coordenadaX = randomEstrella.nextInt(1000000);
            int coordenadaY = randomEstrella.nextInt(1000000);
            int coordenadaZ = randomEstrella.nextInt(1000000);
            Estrella estrella = new Estrella(nombreEstrella, coordenadaX, coordenadaY, coordenadaZ, i);
            estrellaRepository.save(estrella);
            if(randomPlaneta.nextInt(100) < 1){
                int numPlanetas = randomPlaneta.nextInt(3);
                for(int j=0;j<numPlanetas+1;j++){
                    String nombrePlaneta = randomGenPlaneta.generate(7,20);
                    Planeta planeta = new Planeta(nombrePlaneta, contPlaneta, estrella);
                    planetaRepository.save(planeta);
                    contPlaneta++;
                }
            }
            

        }

        //Inserta los productos
        LOG.info("INSERTANDO: Productos");
        for(int i=0;i<NUM_PRODUCTOS;i++){
            String nombreProducto = randomGenProducto.generate(7,20);
            int factorDemanda = randomProducto.nextInt(100);
            int stock = randomProducto.nextInt(100);
            int factorOferta =  randomProducto.nextInt(100);
            Producto producto = new Producto(nombreProducto, i,factorDemanda, stock, factorOferta, i+1);
            productoRepository.save(producto);
        }

        //Inserta las naves
        LOG.info("INSERTANDO: Naves");
        for(int i=0;i<NUM_NAVES;i++){
            String nombreNave = randomGenNave.generate(7,20);
            int carga = 0;
            int velocidad = randomNave.nextInt(100);
            int idEstrella =  randomProducto.nextInt(NUM_ESTRELLAS);
            Estrella estrella = estrellaRepository.findByEid(idEstrella);
            
            if(estrella != null){
                Nave nave = new Nave(nombreNave, carga, velocidad, estrella, i);
                naveRepository.save(nave);
            }
        }
         //Inserta los Usuarios
         LOG.info("INSERTANDO: Usuarios");
         int usuariosXEquipo = NUM_USUARIOS / NUM_EQUIPOS;
         int contUsuarios = 0;
         for(int i=0;i<NUM_EQUIPOS;i++){
            int idNave =  randomProducto.nextInt(NUM_NAVES);
            Nave nave = naveRepository.findByNid(idNave);
            if(nave != null){
                for(int j=0; j<usuariosXEquipo; j++){
                    String username = randomGenUsuario.generate(1,30);
                    String password = randomGenUsuario.generate(6,20);
                    String rol = "Piloto";
                    String correo = randomGenUsuario.generate(10,30);
                    int credito = 0;
                    int tiempoDeJuego = 0;
                    Usuario usuario = new Usuario(contUsuarios,username, password, rol, correo, credito, tiempoDeJuego, nave);
                    usuarioRepository.save(usuario);
                    contUsuarios++;
                }
            } 
             
         }

    }
}
