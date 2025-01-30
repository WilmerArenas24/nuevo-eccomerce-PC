package wd.tienda_on_pc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wd.tienda_on_pc.entity.Categoria;

public interface CategoriaRepositorio extends JpaRepository<Categoria, Integer> {
}
