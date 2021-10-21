package com.example.proyectodw.services;

import java.util.List;
import java.util.Optional;

import com.example.proyectodw.DAO.TransaccionRepository;
import com.example.proyectodw.model.Transaccion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransaccionService {
    @Autowired
    private TransaccionRepository transaccionRepository;

    public Transaccion crearTransaccion(Transaccion transaccion) {
        return transaccionRepository.save(transaccion); // Se crea un único usuario
    }

    public List<Transaccion> crearTransacciones(List<Transaccion> transacciones) {
        return (List<Transaccion>) transaccionRepository.saveAll(transacciones); // Se crean varios usuarios
    }

    public Transaccion getTransaccionById(Long id) {
        return transaccionRepository.findById(id).orElse(null); // Retorna un usuario según su id
    }

    public List<Transaccion> getTransacciones() {
        return (List<Transaccion>) transaccionRepository.findAll(); // Retorna todos los usuarios
    }

    public Transaccion updateTransaccion(Transaccion transaccion) {
        Optional<Transaccion> transaccionOpcional = transaccionRepository.findById(transaccion.getID());
        Transaccion transaccionEncontrado = null;
        if (transaccionOpcional.isPresent()) {

            transaccionEncontrado = transaccionOpcional.get();
            transaccionEncontrado.setPrecioTotal(transaccion.getPrecioTotal());
            transaccionEncontrado.setTid(transaccion.getTid());
            transaccionEncontrado.setTipo(transaccion.getTipo());
            transaccionEncontrado.setUsuario(transaccion.getUsuario());
            
            transaccionRepository.save(transaccionEncontrado);
        } else {
            return new Transaccion();
        }
        return transaccionEncontrado;
    }

    public String deleteTransaccionById(Long id){
        transaccionRepository.deleteById(id);
        return "Transaccion eliminado correctamente";
    }

}
