package com.example.proyectodw.services;

import java.util.List;
import java.util.Optional;

import com.example.proyectodw.DAO.NaveProductoRepository;
import com.example.proyectodw.DAO.NaveRepository;
import com.example.proyectodw.DAO.ProductoRepository;
import com.example.proyectodw.model.NaveProducto;
import com.example.proyectodw.model.Nave;
import com.example.proyectodw.model.Producto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NaveProductoService {
    @Autowired
    private NaveProductoRepository naveProductoRepository;

    @Autowired
    private NaveRepository naveRepository;

    public NaveProducto crearNaveProducto(NaveProducto naveProducto) {
        return naveProductoRepository.save(naveProducto);
    }

    public List<NaveProducto> crearNavesProducto(List<NaveProducto> navesProducto) {
        return (List<NaveProducto>) naveProductoRepository.saveAll(navesProducto);
    }

    public NaveProducto getNaveProductoById(Long id) {
        return naveProductoRepository.findById(id).orElse(null);
    }

    public NaveProducto getNaveProductoDoubleId(Long nid, Long prid) {
        Nave nave = naveRepository.findById(nid).orElse(null);
        if(nave != null){
            List<NaveProducto> navesProductos = nave.getProductos();
            for(NaveProducto np : navesProductos){
                if(np.getProducto().getID() == prid)
                    return np;
            }
        }
        return null;
    }

    public List<NaveProducto> getNavesProducto() {
        return (List<NaveProducto>) naveProductoRepository.findAll();
    }

    public NaveProducto updateNaveProducto(NaveProducto naveProducto) {
        Optional<NaveProducto> naveProductoOpcional = naveProductoRepository.findById(naveProducto.getID());
        NaveProducto naveProductoEncontrado = null;
        if (naveProductoOpcional.isPresent()) {
            naveProductoEncontrado = naveProductoOpcional.get();
            naveProductoEncontrado.setCantidad(naveProducto.getCantidad());
            naveProductoEncontrado.setNave(naveProducto.getNave());
            naveProductoEncontrado.setProducto(naveProducto.getProducto());
            naveProductoRepository.save(naveProductoEncontrado);
        } else {
            return new NaveProducto();
        }
        return naveProductoEncontrado;
    }

    public String deleteNaveProductoById(Long id) {
        naveProductoRepository.deleteById(id);
        return "Nave Producto eliminado de manera correcta";
    }
}
