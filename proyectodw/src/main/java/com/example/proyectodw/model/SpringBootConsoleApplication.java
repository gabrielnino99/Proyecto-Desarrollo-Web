package com.example.proyectodw.model;

import com.example.proyectodw.DAO.*;

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
    /*
    public static final int NUM_ESTRELLAS = 40000;
    public static final int NUM_PRODUCTOS = 500;
    public static final int NUM_NAVES = 20;
    public static final int NUM_USUARIOS = 100;
    public static final int NUM_EQUIPOS = 10;
    */
    public static final int NUM_ESTRELLAS = 50;
    public static final int NUM_PRODUCTOS = 5;
    public static final int NUM_NAVES = 20;
    public static final int NUM_USUARIOS = 10;
    public static final int NUM_EQUIPOS = 10;

    @Autowired
    AgujeroDeGusanoRepository agujeroDeGusanoRepository;

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
 
    @Override
    @Transactional
    public void run(String... args) {
        Random randomEstrella = new Random(1234);
        Random randomX = new Random(0);
        Random randomY = new Random(0);
        Random randomZ = new Random(0);
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

        //Inserta los Agujeros de Gusano Bandera
        LOG.info("INSERTANDO: Agujeros de Gusano que seran la quinta parte de las Estrellas");
        int num_agujeros = NUM_ESTRELLAS / 5;
        for(int i=0;i<num_agujeros;i++){
            AgujeroDeGusano agujero = new AgujeroDeGusano(0);
            agujeroDeGusanoRepository.save(agujero);
        }
        //Inserta las estrellas
        LOG.info("INSERTANDO: Estrellas con 1% de probabilidad de tener entre 1 y 3 Planetas");
        Estrella semilla = new Estrella("alpha", 0,0,0,0);
        estrellaRepository.save(semilla);
        int incremento = 0;
        int contPlaneta = 0;
       
        int contEstrella = 1;
        while(contEstrella < NUM_ESTRELLAS){
            int incremento2 = 10;
            for(int j=0;j<contEstrella*3;j++){
                String nombreEstrella = randomGenEstrella.generate(5,15);
                int coordenadaX = incremento + incremento2;
                int coordenadaY = incremento + incremento2;
                int coordenadaZ = incremento + incremento2;
                int coordRandom = randomEstrella.nextInt(3);
                if(coordRandom == 0){
                    coordenadaX += randomX.nextInt(1000);
                }
                else if(coordRandom == 1){
                    coordenadaY += randomY.nextInt(1000);
                }
                else if(coordRandom == 2){
                    coordenadaZ += randomZ.nextInt(1000);
                }
                Estrella estrella = new Estrella(nombreEstrella, coordenadaX, coordenadaY, coordenadaZ, contEstrella+j);
                estrellaRepository.save(estrella);
                if(randomPlaneta.nextInt(100) < 1){
                    int numPlanetas = randomPlaneta.nextInt(3);
                    for(int k=0;k<numPlanetas+1;k++){
                        String nombrePlaneta = randomGenPlaneta.generate(7,20);
                        Planeta planeta = new Planeta(nombrePlaneta, contPlaneta, estrella);
                        planetaRepository.save(planeta);
                        contPlaneta++;
                    }
                }
                incremento2 += 10; 
            }
            contEstrella = contEstrella + contEstrella*3;
            incremento += 1000;
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
        //Nave de prueba FrontEnd
        Estrella estrella = estrellaRepository.findByEid(0);
        if(estrella != null){
            Nave nave = new Nave("Prometeo", 0, 300, estrella, 21);
            naveRepository.save(nave);
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
         //Usuario de prueba FrontEnd
         Nave miNave = naveRepository.findByNid(21);
         if(miNave != null){
            Usuario usuario = new Usuario(11,"Nova", "1", "capitan", "nova@gmail.com", 0, 0, miNave);
            usuarioRepository.save(usuario);
         }
    }
}
