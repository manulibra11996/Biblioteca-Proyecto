package com.example.Biblioteca_Version_2.controler;

import com.example.Biblioteca_Version_2.entities.Categoria;
import com.example.Biblioteca_Version_2.repositories.CategoriaRepository;
import com.example.Biblioteca_Version_2.repositories.LibroRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Controller
public class CategoriaControllers {
    // anotación que mapea las peticiones GET a la URL "/alquiler"

    private final CategoriaRepository categoriaRepository;
    private final LibroRepository libroRepository;


    @GetMapping("/categoria") // http://localhost:8080/productos
    public String findAll(Model model) {

        List<Categoria> categorias = categoriaRepository.findAll();
        model.addAttribute("categoria", categorias);

        return "categoria/categoria-list";
    }

    @GetMapping("/categoria/{id}") // http://localhost:8080/productos/1
    public String findById(Model model, @PathVariable Long id) {
        Optional<Categoria> categoriaOpt = categoriaRepository.findById(id);

        if (categoriaOpt.isPresent()) {
            model.addAttribute("categoria", categoriaOpt.get());
        } else {
            model.addAttribute("error", "404 Categoria Not Found");
        }

        return "categoria/categoria-detail";
    }

    @PostMapping("/categoria/{id}/eliminar")
    public String delete(@PathVariable Long id) {
        if (libroRepository.countByCategoria_Id(id) > 0) {
            return "redirect:/categoria?error=true";
        }
        categoriaRepository.deleteById(id);

        return "redirect:/categoria";
    }

}
