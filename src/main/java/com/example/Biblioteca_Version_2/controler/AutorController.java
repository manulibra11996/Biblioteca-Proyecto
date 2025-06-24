package com.example.Biblioteca_Version_2.controler;

import com.example.Biblioteca_Version_2.entities.Autor;
import com.example.Biblioteca_Version_2.repositories.AutorRepository;
import com.example.Biblioteca_Version_2.repositories.LibroRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Controller
public class AutorController {
    private final LibroRepository libroRepository;

    private final AutorRepository autorRepository;


    @GetMapping("/autor") // http://localhost:8080/productos
    public String findAll(Model model) {

        List<Autor> autor = autorRepository.findAll();
        model.addAttribute("autor", autor);

        return "autor/autor-list";
    }

    @GetMapping("/autor/{id}") // http://localhost:8080/productos/1
    public String findById(Model model, @PathVariable Long id) {
        Optional<Autor> autorOpt = autorRepository.findById(id);

        if (autorOpt.isPresent()) {
            model.addAttribute("autor", autorOpt.get());
        } else {
            model.addAttribute("error", "404 Autor Not Found");
        }

        return "autor/autor-detail";
    }

    // mostrar formulario para crear nuevo autor
    @GetMapping("/autor/nuevo")
    public String createForm(Model model) {
        model.addAttribute("autor", new Autor());

        return "autor/autor-form";
    }

    // mostrar formulario para editar autor existente
    @GetMapping("/autor/{id}/editar")
    public String editForm(Model model, @PathVariable Long id) {
        Optional<Autor> autorOpt = autorRepository.findById(id);

        if (autorOpt.isPresent()) {
            model.addAttribute("autor", autorOpt.get());
        } else {
            model.addAttribute("error", "Autor no encontrado");
        }

        return "autor/autor-form";
    }

    // procesar formulario (crear o actualizar)
    @PostMapping("/autor")
    public String saveForm(@ModelAttribute Autor autor) {
        autorRepository.save(autor);
        return "redirect:/autor";
    }
    
    @PostMapping("/autor/{id}/eliminar")
    public String delete(@PathVariable Long id) {
        if (libroRepository.countByAutor_Id(id) > 0) {
            return "redirect:/autor?error=true";
        }
        autorRepository.deleteById(id);

        return "redirect:/autor";
    }

}
