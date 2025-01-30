package wd.tienda_on_pc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wd.tienda_on_pc.entity.Categoria;
import wd.tienda_on_pc.entity.Producto;
import wd.tienda_on_pc.repository.CategoriaRepositorio;

import java.util.List;

@Service
public class CategoriaServicio implements ICategoriaServicio{
    @Autowired
    private CategoriaRepositorio categoriaRepositorio;

    @Override
    public List<Categoria> ListarCategoria() {
        return categoriaRepositorio.findAll();
    }

    @Override
    public Categoria buscarCategoriaId(Integer categoria_id) {
        return categoriaRepositorio.findById(categoria_id).orElse(null);
    }

    @Override
    public Categoria guardarCategoria(Categoria categoria) {
        return categoriaRepositorio.save(categoria);
    }

    @Override
    public void eliminarCategoria(Categoria categoria) {
        categoriaRepositorio.delete(categoria);
    }
}
