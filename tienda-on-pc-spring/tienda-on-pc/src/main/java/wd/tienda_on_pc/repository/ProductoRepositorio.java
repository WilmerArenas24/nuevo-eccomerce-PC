package wd.tienda_on_pc.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import wd.tienda_on_pc.entity.Producto;

public interface ProductoRepositorio extends JpaRepository<Producto, Integer> {

}
