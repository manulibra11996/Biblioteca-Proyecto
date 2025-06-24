package com.example.Biblioteca_Version_2.controler;

import com.example.Biblioteca_Version_2.entidades.Categorias;

import java.util.ArrayList;
import java.util.List;

public class CategoriasControllers {
    private List<Categorias> categoria;

    public CategoriasControllers() {
        this.categoria = new ArrayList<>();
    }

    // Método para agregar una nueva categoría
    public void agregarCategoria(int id, String nombre, String descripcion) {
        Categorias nuevaCategoria = new Categorias(id, nombre, descripcion);
        categoria.add(nuevaCategoria);
        System.out.println("Categoría añadida: " + nuevaCategoria);
    }

    // Método para obtener todas las categorías
    public List<Categorias> obtenerCategorias() {
        return categoria;
    }

    // Método para buscar una categoría por ID
    public Categorias buscarCategoriaPorId(int id) {
        for (Categorias categoria : categoria) {
            if (categoria.getId() == id) {
                return categoria;
            }
        }
        return null;
    }

    // Método para eliminar una categoría por ID
    public boolean eliminarCategoria(int id) {
        Categorias categoria = buscarCategoriaPorId(id);
        if (categoria != null) {
            categoria.remove(categoria);
            System.out.println("Categoría eliminada: " + categoria);
            return true;
        }
        return false;
    }
}