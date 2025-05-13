package br.com.fiap.redeancora.controller;

import br.com.fiap.redeancora.model.Peca;
import br.com.fiap.redeancora.service.PecaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pecas")
public class PecaController {

    private final PecaService service;

    public PecaController(PecaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Peca> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public Peca salvar(@RequestBody Peca peca) {
        return service.salvar(peca);
    }

    @GetMapping("/{id}")
    public Peca buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}