package com.example.Biblioteca_Version_2.controler;

import com.example.Biblioteca_Version_2.repositories.AutorRepository;
import com.example.Biblioteca_Version_2.repositories.CategoriaRepository;
import com.example.Biblioteca_Version_2.repositories.PrestamoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.example.Biblioteca_Version_2.entities.Libro;
import com.example.Biblioteca_Version_2.repositories.LibroRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Slf4j
@RequiredArgsConstructor
@Controller
public class LibroControllers {
    private final CategoriaRepository categoriaRepository;
    private final LibroRepository libroRepository;
    private final AutorRepository autorRepository;
    private final PrestamoRepository prestamoRepository;

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

    // mostrar formulario para crear nuevo libro
    @GetMapping("/libro/nuevo")
    public String createForm(Model model) {
        model.addAttribute("libro", new Libro());
        model.addAttribute("autor", autorRepository.findAll());
        model.addAttribute("categoria", categoriaRepository.findAll());
        return "libros/libros-form";
    }

    // mostrar formulario para editar libro existente
    @GetMapping("/libro/{id}/editar")
    public String editForm(Model model, @PathVariable Long id) {
        Optional<Libro> libroOpt = libroRepository.findById(id);

        if (libroOpt.isPresent()) {
            model.addAttribute("libro", libroOpt.get());
            model.addAttribute("autor", autorRepository.findAll());
            model.addAttribute("categoria", categoriaRepository.findAll());
        } else {
            model.addAttribute("error", "Libro no encontrado");
        }

        return "libros/libros-form";
    }

    // procesar formulario (crear o actualizar)
    @PostMapping("/libro")
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
