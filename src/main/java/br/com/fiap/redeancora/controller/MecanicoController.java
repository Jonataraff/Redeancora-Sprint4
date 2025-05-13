package br.com.fiap.redeancora.controller;

import br.com.fiap.redeancora.model.Mecanico;
import br.com.fiap.redeancora.service.MecanicoService;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@RestController
@RequestMapping("/mecanicos")
public class MecanicoController {

    private final MecanicoService service;

    public MecanicoController(MecanicoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Mecanico> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public Mecanico salvar(@RequestBody Mecanico mecanico) {
        return service.salvar(mecanico);
    }
    @PostMapping("/login")
    public String loginMecanico(@RequestParam String email, @RequestParam String senha, Model model) {
        Mecanico mecanico = service.listarTodos().stream()
                .filter(m -> m.getEmail().equals(email) && m.getSenha().equals(senha))
                .findFirst()
                .orElse(null);

        if (mecanico == null) {
            model.addAttribute("erro", "Email ou senha inválidos");
            return "login-mecanico";
        }

        model.addAttribute("mecanico", mecanico);
        return "redirect:/clientes"; // Redireciona para a lista de clientes
    }

    @GetMapping("/{id}")
    public Mecanico buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}