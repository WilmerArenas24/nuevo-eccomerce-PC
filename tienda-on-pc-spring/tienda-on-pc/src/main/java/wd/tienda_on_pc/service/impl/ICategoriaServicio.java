package wd.tienda_on_pc.service.impl;

import wd.tienda_on_pc.entity.Categoria;

import java.util.List;

public interface ICategoriaServicio {
    public List<Categoria> ListarCategoria();

    public Categoria buscarCategoriaId(Integer categoria_id);

    public Categoria guardarCategoria(Categoria categoria);

    public void eliminarCategoria(Categoria categoria);
}
