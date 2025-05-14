package br.com.fiap.redeancora.controller;

import br.com.fiap.redeancora.model.Cliente;
import br.com.fiap.redeancora.model.Mecanico;
import br.com.fiap.redeancora.repository.ClienteRepository;
import br.com.fiap.redeancora.repository.MecanicoRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private MecanicoRepository mecanicoRepository;

    @GetMapping("/login/cliente")
    public String loginClienteForm(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "login/login-cliente";
    }

    @PostMapping("/login/cliente")
    public String processarLoginCliente(@ModelAttribute Cliente clienteForm, HttpSession session, Model model) {
        Cliente clienteAutenticado = clienteRepository.findByEmail(clienteForm.getEmail());

        if (clienteAutenticado != null && clienteAutenticado.getSenha().equals(clienteForm.getSenha())) {
            session.setAttribute("clienteLogado", clienteAutenticado);
            return "clientes/menu/menu-cliente";
        }

        model.addAttribute("erro", "Credenciais inválidas");
        return "clientes/menu/menu-cliente";
    }

    @GetMapping("/login/mecanico")
    public String loginMecanicoForm(Model model) {
        model.addAttribute("mecanico", new Mecanico());
        return "login/login-mecanico";
    }

    @PostMapping("/login/mecanico")
    public String processarLoginMecanico(@ModelAttribute Mecanico mecanicoForm, HttpSession session, Model model) {
        Mecanico mecanicoAutenticado = mecanicoRepository
                .findByEmail(mecanicoForm.getEmail());

        if (mecanicoAutenticado != null) {
            session.setAttribute("mecanicoLogado", mecanicoAutenticado);
            return "clientes/menu/menu-mecanico";
        } else {
            model.addAttribute("erro", "Credenciais inválidas");
            return "clientes/login/login-mecanico";
        }
    }
}
