package com.example.Biblioteca_Version_2.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "Página_principal_Librocultour"; // Thymeleaf buscará templates/index.html
    }
}