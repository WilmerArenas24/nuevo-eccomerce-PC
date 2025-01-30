package wd.tienda_on_pc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wd.tienda_on_pc.entity.Producto;
import wd.tienda_on_pc.service.impl.IProductoServicio;
import wd.tienda_on_pc.service.impl.ProductoServicio;

import java.util.List;

@RestController
@RequestMapping("/public")
@CrossOrigin(value = "http://localhost:3000")
public class ProductoControlador {
    private static Logger logger =
    LoggerFactory.getLogger(ProductoControlador.class);

    //Comunicarnos con la capa de servicio
    @Autowired
    private IProductoServicio productoServicio;

    @GetMapping("/productos")
    public List<Producto> obteberProductos(){
        var productos = productoServicio.listarProductos();

        //Imprimiendo en consola
        productos.forEach((producto -> logger.info(producto.toString())));

        return productos;
    }

}
