package br.com.fiap.redeancora.controller;

import br.com.fiap.redeancora.model.Veiculo;
import br.com.fiap.redeancora.service.VeiculoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    private final VeiculoService service;

    public VeiculoController(VeiculoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Veiculo> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public Veiculo salvar(@RequestBody Veiculo veiculo) {
        return service.salvar(veiculo);
    }

    @GetMapping("/{id}")
    public Veiculo buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}