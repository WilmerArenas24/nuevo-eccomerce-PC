package wd.tienda_on_pc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wd.tienda_on_pc.entity.Producto;
import wd.tienda_on_pc.repository.ProductoRepositorio;

import java.util.List;

@Service
public class ProductoServicio implements IProductoServicio{
    @Autowired
    private ProductoRepositorio productoRepositorio;


    @Override
    public List<Producto> listarProductos() {
        return productoRepositorio.findAll();
    }

    @Override
    public Producto buscarProductoPorId(Integer productoId) {
        Producto producto = productoRepositorio.findById(productoId).orElse(null);
        return producto;
    }

    @Override
    public Producto guardarProducto(Producto producto) {
        return productoRepositorio.save(producto);

    }

    @Override
    public void eliminarProducto(Producto producto) {
        productoRepositorio.delete(producto);

    }
}
