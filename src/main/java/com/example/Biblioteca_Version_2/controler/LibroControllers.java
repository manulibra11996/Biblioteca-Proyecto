package com.example.Biblioteca_Version_2.controler;

import com.example.Biblioteca_Version_2.repositories.PrestamoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.example.Biblioteca_Version_2.entities.Libro;
import com.example.Biblioteca_Version_2.repositories.CategoriaRepository;
import com.example.Biblioteca_Version_2.repositories.LibroRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Slf4j
@RequiredArgsConstructor
@Controller
public class LibroControllers {
    private final PrestamoRepository prestamoRepository;

    private final CategoriaRepository categoriasRepositories;
    private final LibroRepository libroRepository;


    @GetMapping("/libro") // http://localhost:8080/productos
    public String findAll(Model model) {

        List<Libro> libros = libroRepository.findAll();
        model.addAttribute("libro", libros);

        return "libros/libros-list";
    }

    @GetMapping("/libro/{id}") // http://localhost:8080/productos/1
    public String findById(Model model, @PathVariable Long id) {
        Optional<Libro> libroOpt = libroRepository.findById(id);

        if (libroOpt.isPresent()) {
            model.addAttribute("libro", libroOpt.get());
        } else {
            model.addAttribute("error", "404 Libros Not Found");
        }

        return "libros/libros-detail";
    }

    @GetMapping("/libros/nuevo")
    public String createForm(Model model) {
        model.addAttribute("libro", new Libro());
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
    public String saveForm(@ModelAttribute Libro libro) {
        libroRepository.save(libro);

        return "redirect:/libros";
    }

    @PostMapping("/libro/{id}/eliminar")
    public String delete(@PathVariable Long id) {
        if (prestamoRepository.countByLibro_Id(id) > 0) {
            return "redirect:/libro?error=true";
        }
        libroRepository.deleteById(id);

        return "redirect:/libro";
    }

    //@PostMapping("/libros/{id}/eliminar")
    //public String delete(@PathVariable Long id) {
     //   LibrosRepositories.deleteById(id);

       // return "redirect:/libros";
   // }


}
