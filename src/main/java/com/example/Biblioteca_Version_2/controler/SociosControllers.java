package com.example.Biblioteca_Version_2.controler;

import com.example.Biblioteca_Version_2.entities.Categorias;
import com.example.Biblioteca_Version_2.entities.Socios;
import com.example.Biblioteca_Version_2.repositories.CategoriasRepositories;
import com.example.Biblioteca_Version_2.repositories.SociosRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Controller
public class SociosControllers {

    @Autowired
    private SociosRepositories sociosRepositories;

    @GetMapping
    public List<Socios> getAllSocios() {

        return sociosRepositories.findAll();

    }

    public SociosControllers(SociosRepositories sociosRepositories) {
        this.sociosRepositories = sociosRepositories;
    }

    @GetMapping("/socio") // http://localhost:8080/productos
    public String findAll(Model model) {

        List<Socios> socios = sociosRepositories.findAll();
        model.addAttribute("socio", socios);

        return "socios/socio-list";
    }

    @GetMapping("/socio/{id}") // http://localhost:8080/productos/1
    public String findById(Model model, @PathVariable Long id) {
        Optional<Socios> sociosOpt = sociosRepositories.findById(id);

        if (sociosOpt.isPresent()) {
            model.addAttribute("libro", sociosOpt.get());
        } else {
            model.addAttribute("error", "404 Socios Not Found");
        }

        return "socios/socio-detail";
    }
}
