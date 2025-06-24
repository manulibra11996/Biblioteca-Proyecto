package com.example.Biblioteca_Version_2.controler;

import com.example.Biblioteca_Version_2.entities.Socio;
import com.example.Biblioteca_Version_2.repositories.PrestamoRepository;
import com.example.Biblioteca_Version_2.repositories.SocioRepository;
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
public class SocioControllers {
    private final PrestamoRepository prestamoRepository;

    private final SocioRepository socioRepository;

    @GetMapping("/socio") // http://localhost:8080/productos
    public String findAll(Model model) {

        List<Socio> socios = socioRepository.findAll();
        model.addAttribute("socio", socios);

        return "socios/socio-list";
    }

    @GetMapping("/socio/{id}") // http://localhost:8080/productos/1
    public String findById(Model model, @PathVariable Long id) {
        Optional<Socio> sociosOpt = socioRepository.findById(id);

        if (sociosOpt.isPresent()) {
            model.addAttribute("socio", sociosOpt.get());
        } else {
            model.addAttribute("error", "404 Socios Not Found");
        }

        return "socios/socio-detail";
    }
    @GetMapping("/socios/eliminar/{id}")
    public String eliminarSocio(@PathVariable Long id) {
        SocioControllers socioService;
        socioService = null;
        socioService.eliminarSocio(id);
        return "redirect:/socios";
    }

    @PostMapping("/socio/{id}/eliminar")
    public String delete(@PathVariable Long id) {
        if (prestamoRepository.countBySocio_Id(id) > 0) {
            return "redirect:/socio?error=true";
        }
        socioRepository.deleteById(id);

        return "redirect:/socio";
    }
}
