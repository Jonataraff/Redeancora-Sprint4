package br.com.fiap.redeancora.controller;

import br.com.fiap.redeancora.model.Cliente;
import br.com.fiap.redeancora.service.ClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }


    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(ClienteController.class);

    @GetMapping
    public String listar(Model model) {
        logger.info("Acessando página de listagem de clientes");
        model.addAttribute("clientes", service.listarTodos());
        return "clientes/lista";
    }


    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "clientes/form";
    }

    @PostMapping
    public String salvar(@ModelAttribute Cliente cliente) {
        service.salvar(cliente);
        return "redirect:/clientes";
    }

    @GetMapping("/{id}/editar")
    public String editar(@PathVariable Long id, Model model) {
        Cliente cliente = service.buscarPorId(id);
        model.addAttribute("cliente", cliente);
        return "clientes/form";
    }

    @GetMapping("/{id}/excluir")
    public String excluir(@PathVariable Long id) {
        service.deletar(id);
        return "redirect:/clientes";
    }
    @GetMapping("/menu")
    public String menuCliente() {
        return "clientes/menu/menu-cliente";
    }
}

