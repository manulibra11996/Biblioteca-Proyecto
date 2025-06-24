package com.example.Biblioteca_Version_2.controler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.example.Biblioteca_Version_2.entities.Libros;
import com.example.Biblioteca_Version_2.repositories.CategoriaRepository;
import com.example.Biblioteca_Version_2.repositories.LibrosRepositories;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Slf4j
@RequiredArgsConstructor
@Controller
public class LibrosControllers {

    private final CategoriaRepository categoriasRepositories;
    private final LibrosRepositories librosRepositories;


    @GetMapping("/libro") // http://localhost:8080/productos
    public String findAll(Model model) {

        List<Libros> libros = librosRepositories.findAll();
        model.addAttribute("libro", libros);

        return "libros/libros-list";
    }

    @GetMapping("/libro/{id}") // http://localhost:8080/productos/1
    public String findById(Model model, @PathVariable Long id) {
        Optional<Libros> libroOpt = librosRepositories.findById(id);

        if (libroOpt.isPresent()) {
            model.addAttribute("libro", libroOpt.get());
        } else {
            model.addAttribute("error", "404 Libros Not Found");
        }

        return "libros/libros-detail";
    }

    @GetMapping("/libros/nuevo")
    public String createForm(Model model) {
        model.addAttribute("libro", new Libros());
        model.addAttribute("categorias", categoriasRepositories.findAll());

        return "libro-form";
    }


    //@GetMapping("/libros/{id}/editar")
    //public String editForm(Model model, @PathVariable Long id) {
    //    Optional<Libros> libroOpt = libroRepository.findById(id);

    //    if (libroOpt.isPresent()) {
     //       model.addAttribute("libro", libroOpt.get());
     //       model.addAttribute("categorias", categoriaRepository.findAll());
     //   } else {
     //       model.addAttribute("error", "Libro no encontrado");
      //  }

      //  return "libro-form";
    //}


    @PostMapping("/libros") // podría ser @PostMapping("/libros/form") si en el formulario pusiera th:action="@{/libros/form}"
    public String saveForm(@ModelAttribute Libros libro) {
        librosRepositories.save(libro);

        return "redirect:/libros";
    }


    //@PostMapping("/libros/{id}/eliminar")
    //public String delete(@PathVariable Long id) {
     //   LibrosRepositories.deleteById(id);

       // return "redirect:/libros";
   // }
}
