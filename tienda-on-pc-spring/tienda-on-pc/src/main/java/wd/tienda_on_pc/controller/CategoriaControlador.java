package wd.tienda_on_pc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wd.tienda_on_pc.entity.Categoria;
import wd.tienda_on_pc.service.impl.ICategoriaServicio;

import java.util.List;

@RestController
@RequestMapping("/public")
@CrossOrigin(value = "http://localhost:3000")
public class CategoriaControlador {
    private static Logger logger = LoggerFactory.getLogger(CategoriaControlador.class);

    @Autowired
    private ICategoriaServicio categoriaServicio;

    @GetMapping("/categorias")
    public List<Categoria> obtenerCategorias(){
        var categorias = categoriaServicio.ListarCategoria();

        categorias.forEach((categoria -> logger.info(categoria.toString())));

        return categorias;
    }
}
