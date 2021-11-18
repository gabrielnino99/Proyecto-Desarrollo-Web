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
import org.springframework.context.annotation.Profile;


@SpringBootApplication
@Profile("default")
public class SpringBootConsoleApplication implements CommandLineRunner{
    private static final Logger LOG = LoggerFactory.getLogger(SpringBootConsoleApplication.class);
    /*
    public static final int NUM_ESTRELLAS = 40000;
    public static final int NUM_PRODUCTOS = 500;
    public static final int NUM_NAVES = 20;
    public static final int NUM_USUARIOS = 100;
    public static final int NUM_EQUIPOS = 10;
    */

    //DATOS DE PRUEBA
    //Si mil estrellas tardan 3 minutos en subir, estimando matematicamente
    //40 mil estrellas tardarian 120 minutos, es decir, 2 horas
    
    
    public static final int NUM_ESTRELLAS = 1000;
    public static final int NUM_PRODUCTOS = 500;
    public static final int NUM_NAVES = 20;
    public static final int NUM_USUARIOS = 100;
    public static final int NUM_EQUIPOS = 10;
    
    

    @Autowired
    AgujeroDeGusanoRepository agujeroDeGusanoRepository;

    @Autowired
    AgujeroDeGusanoEstrellaRepository agujeroDeGusanoEstrellaRepository;

    @Autowired
    EstrellaRepository estrellaRepository;

    @Autowired
    NaveRepository naveRepository;

    @Autowired
    PlanetaRepository planetaRepository;

    @Autowired
    PlanetaProductoRepository planetaProductoRepository;

    @Autowired
    ProductoRepository productoRepository;

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
        //Inserta los Datos de prueba
        LOG.info("INSERTANDO: Estrella Semilla, Usuario Prueba y Nave Prueba");
        Estrella semilla = new Estrella("alpha", 0,0,0,0);
        estrellaRepository.save(semilla);
        int incremento = 0;
        int contPlaneta = 0;
        //Temporal
        int numPlanetast = randomPlaneta.nextInt(3);
        for(int k=0;k<numPlanetast+1;k++){
            String nombrePlaneta = randomGenPlaneta.generate(7,20);
            Planeta planeta = new Planeta(nombrePlaneta, contPlaneta, semilla);
            planetaRepository.save(planeta);
            contPlaneta++;
        }

        //Nave de prueba FrontEnd
        Estrella estrella1 = estrellaRepository.findByEid(0);
        if(estrella1 != null){
            Nave nave = new Nave("Prometeo", 0.0, 120.0, 300, estrella1, 21);
            naveRepository.save(nave);
        }

         //Usuario de prueba FrontEnd
         Nave miNave = naveRepository.findByNid(21);
         if(miNave != null){
            Usuario usuario = new Usuario(11,"Nova", "1", "capitan", "nova@gmail.com", 1000000, 0, miNave);
            usuarioRepository.save(usuario);
         }

        //Inserta los Agujeros de Gusano Bandera
        LOG.info("INSERTANDO: Agujeros de Gusano que seran la quinta parte de las Estrellas");
        int num_agujeros = NUM_ESTRELLAS / 5;
        for(int i=0;i<num_agujeros;i++){
            AgujeroDeGusano agujero = new AgujeroDeGusano(i);
            agujeroDeGusanoRepository.save(agujero);
        }
        //Inserta las estrellas
        LOG.info("INSERTANDO: Estrellas con 1% de probabilidad de tener entre 1 y 3 Planetas");
       
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
       //Conectar Estrellas con Agujeros de Gusano
       LOG.info("CONECTANDO: Estrellas con Agujeros de Gusano");
       for(int i=0;i<num_agujeros;i++){
            AgujeroDeGusano agujero = agujeroDeGusanoRepository.findByAid(i);
            int eidA =  randomEstrella.nextInt(NUM_ESTRELLAS);
            Estrella estrellaA = estrellaRepository.findByEid(eidA);
            int eidB = 0;
            do{
                eidB = randomEstrella.nextInt(NUM_ESTRELLAS);
            }while(eidA == eidB);
            Estrella estrellaB = estrellaRepository.findByEid(eidB);
            AgujeroDeGusanoEstrella agujeroEstrellaA = new AgujeroDeGusanoEstrella("A", agujero,estrellaA);
            agujeroDeGusanoEstrellaRepository.save(agujeroEstrellaA);
            AgujeroDeGusanoEstrella agujeroEstrellaB = new AgujeroDeGusanoEstrella("B", agujero,estrellaB);
            agujeroDeGusanoEstrellaRepository.save(agujeroEstrellaB);
        }
        //Inserta los productos
        LOG.info("INSERTANDO: Productos");
        for(int i=0;i<NUM_PRODUCTOS;i++){
            String nombreProducto = randomGenProducto.generate(7,20);
            double metros3 = randomProducto.nextDouble();
            Producto producto = new Producto(nombreProducto, i, 0, metros3);
            productoRepository.save(producto);
        }

        //Conectar Planetas y Productos
       LOG.info("CONECTANDO: Planetas y Productos");
       for(int i=0;i<NUM_PRODUCTOS;i++){
           Producto producto = productoRepository.findByPrid(i);
            for(int j=0; j<contPlaneta;j++){
                int probabilidadPlaneta = randomPlaneta.nextInt(100);
                if(probabilidadPlaneta < 70){
                    Planeta planeta = planetaRepository.findByPlid(j);
                    int factorDemanda = randomProducto.nextInt(1000000);
                    int stock = randomProducto.nextInt(1000000);
                    int factorOferta =  randomProducto.nextInt(1000000);
                    PlanetaProducto planetaProducto = new PlanetaProducto(factorDemanda, stock, factorOferta, planeta,producto);
                    planetaProductoRepository.save(planetaProducto);
                }
            }
        }

        //Inserta las naves
        LOG.info("INSERTANDO: Naves");
        for(int i=0;i<NUM_NAVES;i++){
            String nombreNave = randomGenNave.generate(7,20);
            double carga = 0.0;
            double cargaMaxima = (randomNave.nextDouble() + 1) * 100;
            int velocidad = randomNave.nextInt(100);
            int idEstrella =  randomEstrella.nextInt(NUM_ESTRELLAS);
            Estrella estrella = estrellaRepository.findByEid(idEstrella);
            
            if(estrella != null){
                Nave nave = new Nave(nombreNave, carga, cargaMaxima,velocidad, estrella, i);
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
                    int credito = 1000000;
                    int tiempoDeJuego = 0;
                    Usuario usuario = new Usuario(contUsuarios,username, password, rol, correo, credito, tiempoDeJuego, nave);
                    usuarioRepository.save(usuario);
                    contUsuarios++;
                }
            } 
             
         }
        
    }
}
