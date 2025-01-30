package wd.tienda_on_pc.service.impl;

import org.springframework.security.core.parameters.P;
import wd.tienda_on_pc.entity.Producto;

import java.util.List;

public interface IProductoServicio {
    public List<Producto> listarProductos();

    public Producto buscarProductoPorId(Integer producto_id);

    public Producto guardarProducto(Producto producto);

    public void eliminarProducto(Producto producto);

}
