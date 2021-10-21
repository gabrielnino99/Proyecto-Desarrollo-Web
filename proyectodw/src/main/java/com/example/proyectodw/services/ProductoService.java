package com.example.proyectodw.services;

import java.util.List;
import java.util.Optional;

import com.example.proyectodw.DAO.ProductoRepository;
import com.example.proyectodw.model.Producto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    public Producto crearProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public List<Producto> crearProductos(List<Producto> productos) {
        return (List<Producto>) productoRepository.saveAll(productos);
    }

    public Producto getProductoById(Long id) {
        return productoRepository.findById(id).orElse(null);
    }

    public List<Producto> getProductos() {
        return (List<Producto>) productoRepository.findAll();
    }

    public Producto updateProducto(Producto producto) {
        Optional<Producto> productoOpcional = productoRepository.findById(producto.getID());
        Producto productoEncontrado = null;
        if (productoOpcional.isPresent()) {

            productoEncontrado = productoOpcional.get();
            productoEncontrado.setNombre(producto.getNombre());
            productoEncontrado.setMetros3(producto.getMetros3());
            productoEncontrado.setColumn(producto.getColumn());

            productoRepository.save(productoEncontrado);
        } else {
            return new Producto();
        }
        return productoEncontrado;
    }

    public String deleteProductoById(Long id){
        productoRepository.deleteById(id);
        return "Producto eliminado de manera correcta";
    }

}
