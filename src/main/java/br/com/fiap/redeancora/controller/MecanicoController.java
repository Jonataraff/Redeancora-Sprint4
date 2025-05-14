package br.com.fiap.redeancora.controller;

import br.com.fiap.redeancora.model.Cliente;
import br.com.fiap.redeancora.model.Mecanico;
import br.com.fiap.redeancora.service.MecanicoService;
import jakarta.servlet.http.HttpSession;
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

    @GetMapping("/{id}")
    public Mecanico buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}