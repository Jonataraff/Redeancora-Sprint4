package br.com.fiap.redeancora.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(Model model) {
        // Informações básicas da página inicial (se necessário)
        return "home"; // Renderiza o template home.html
    }
}
