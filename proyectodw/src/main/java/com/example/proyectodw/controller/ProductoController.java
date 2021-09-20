package com.example.proyectodw.controller;

import java.util.List;

//import com.example.proyectodw.DAO.ProductoRepository;
import com.example.proyectodw.model.Producto;
import com.example.proyectodw.services.ProductoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductoController {
    
    @Autowired
    private ProductoService productoService;

    @PostMapping("/addProducto")
    public Producto addProducto(@RequestBody Producto producto){
        return productoService.crearProducto(producto);
    }

    @PostMapping("/addProductos")
    public List<Producto> addProductos(@RequestBody List<Producto> productos){
        return productoService.crearProductos(productos);
    }

    @GetMapping("/producto/{id}")
    public Producto getProductoById(@PathVariable Long id){
        return productoService.getProductoById(id);
    }

    @GetMapping("/productos")
    public List<Producto> getAllProductos(){
        return productoService.getProductos();
    }

    @PutMapping("/updateProducto")
    public Producto updateProducto(@RequestBody Producto producto){
        return productoService.updateProducto(producto);
    }

    @DeleteMapping("/producto/{id}")
    public String deleteProducto(@PathVariable Long id){
        return productoService.deleteProductoById(id);
    }


}