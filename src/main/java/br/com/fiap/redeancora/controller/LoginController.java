package br.com.fiap.redeancora.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login/cliente")
    public String loginCliente(Model model) {
        // Adiciona qualquer lógica necessária para Login de Cliente (se necessário)
        return "login-cliente"; // Renderiza o template login-cliente.html
    }

    @GetMapping("/login/mecanico")
    public String loginMecanico(Model model) {
        // Adiciona qualquer lógica necessária para Login de Mecânico (se necessário)
        return "login-mecanico"; // Renderiza o template login-mecanico.html
    }
}
