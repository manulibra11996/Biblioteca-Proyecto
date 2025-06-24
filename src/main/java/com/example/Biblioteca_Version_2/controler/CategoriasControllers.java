package com.example.Biblioteca_Version_2.controler;

import com.example.Biblioteca_Version_2.entities.Categorias;
import com.example.Biblioteca_Version_2.entities.Libros;
import com.example.Biblioteca_Version_2.repositories.AutorRepository;
import com.example.Biblioteca_Version_2.repositories.CategoriasRepositories;
import com.example.Biblioteca_Version_2.repositories.LibrosRepositories;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Controller
public class CategoriasControllers {
    // anotación que mapea las peticiones GET a la URL "/alquiler"

    private final CategoriasRepositories categoriasRepositories;


    @GetMapping("/categoria") // http://localhost:8080/productos
    public String findAll(Model model) {

        List<Categorias> categorias = categoriasRepositories.findAll();
        model.addAttribute("categoria", categorias);

        return "categoria/categoria-list";
    }

    @GetMapping("/categoria/{id}") // http://localhost:8080/productos/1
    public String findById(Model model, @PathVariable Long id) {
        Optional<Categorias> categoriaOpt = categoriasRepositories.findById(id);

        if (categoriaOpt.isPresent()) {
            model.addAttribute("categoria", categoriaOpt.get());
        } else {
            model.addAttribute("error", "404 Categoria Not Found");
        }

        return "categoria/categoria-detail";
    }
    @GetMapping("/categorias/eliminar/{id}")
    public String eliminarCategoria(@PathVariable Long id) {
        CategoriasControllers categoriaService = null;
        categoriaService.eliminarCategoria(id);
        return "redirect:/categorias";
    }

}
